package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.*;
import com.armazem.armazem.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueMovimentoRepository movimentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    @Transactional
    public Venda registrarVenda(Venda venda) {
        BigDecimal totalVenda = BigDecimal.ZERO;

        if (venda.getCliente() != null && venda.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(venda.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado: ID " + venda.getCliente().getId()));
            venda.setCliente(cliente);
        } else {
            venda.setCliente(null);
        }

        venda.setStatus("CONCLUIDA");

        for (VendaItem item : venda.getItens()) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: ID " + item.getProduto().getId()));

            if (produto.getEstoqueAtual() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            produto.setEstoqueAtual(produto.getEstoqueAtual() - item.getQuantidade());
            produto.setAtualizadoEm(LocalDateTime.now());
            produtoRepository.save(produto);

            item.setPrecoUnitario(produto.getPrecoVenda());
            BigDecimal subtotal = item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade()));
            item.setSubtotal(subtotal);
            item.setVenda(venda);

            totalVenda = totalVenda.add(subtotal);

            EstoqueMovimento mov = new EstoqueMovimento();
            mov.setProduto(produto);
            mov.setTipo(TipoMovimento.SAIDA);
            mov.setQuantidade(item.getQuantidade());
            mov.setMotivo("Venda");
            mov.setCriadoEm(LocalDateTime.now());
            movimentoRepository.save(mov);
        }

        BigDecimal desconto = venda.getDesconto() != null ? venda.getDesconto() : BigDecimal.ZERO;

        venda.setTotal(totalVenda);
        venda.setDesconto(desconto);

        BigDecimal totalFinal = totalVenda.subtract(desconto);
        venda.setTotalFinal(totalFinal);

        venda.setCriadoEm(LocalDateTime.now());

        return vendaRepository.save(venda);
    }

    @Transactional
    public Venda cancelarVenda(Long id) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        if ("CANCELADA".equals(venda.getStatus())) {
            throw new RuntimeException("A venda já se encontra cancelada.");
        }

        for (VendaItem item : venda.getItens()) {
            Produto produto = item.getProduto();
            produto.setEstoqueAtual(produto.getEstoqueAtual() + item.getQuantidade());
            produto.setAtualizadoEm(LocalDateTime.now());
            produtoRepository.save(produto);

            EstoqueMovimento mov = new EstoqueMovimento();
            mov.setProduto(produto);
            mov.setTipo(TipoMovimento.ENTRADA);
            mov.setQuantidade(item.getQuantidade());
            mov.setMotivo("Estorno de Venda");
            mov.setObservacao("Cancelamento da Venda #" + venda.getId());
            mov.setCriadoEm(LocalDateTime.now());
            movimentoRepository.save(mov);
        }

        venda.setStatus("CANCELADA");
        return vendaRepository.save(venda);
    }
}
