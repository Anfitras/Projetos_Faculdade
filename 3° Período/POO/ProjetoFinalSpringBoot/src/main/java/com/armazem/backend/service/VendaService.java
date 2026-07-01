package com.armazem.backend.service;

import com.armazem.backend.model.Cliente;
import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.TipoMovimento;
import com.armazem.backend.model.Venda;
import com.armazem.backend.model.VendaItem;
import com.armazem.backend.repository.ClienteRepository;
import com.armazem.backend.repository.EstoqueMovimentoRepository;
import com.armazem.backend.repository.ProdutoRepository;
import com.armazem.backend.repository.VendaRepository;
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
        if (venda.getCliente() != null && venda.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(venda.getCliente().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            venda.setCliente(cliente);
        } else {
            venda.setCliente(null);
        }

        BigDecimal totalVenda = BigDecimal.ZERO;

        for (VendaItem item : venda.getItens()) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            if (produto.getEstoqueAtual() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            item.setProduto(produto);
            item.setVenda(venda);
            item.setPrecoUnitario(produto.getPrecoVenda());
            BigDecimal subtotal = item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade()));
            item.setSubtotal(subtotal);

            totalVenda = totalVenda.add(subtotal);
        }

        venda.setTotal(totalVenda);
        if (venda.getDesconto() == null) {
            venda.setDesconto(BigDecimal.ZERO);
        }
        venda.setTotalFinal(totalVenda.subtract(venda.getDesconto()));
        venda.setStatus("CONCLUIDA");
        venda.setCriadoEm(LocalDateTime.now());

        Venda vendaSalva = vendaRepository.save(venda);

        for (VendaItem item : vendaSalva.getItens()) {
            Produto produto = item.getProduto();
            produto.setEstoqueAtual(produto.getEstoqueAtual() - item.getQuantidade());
            produtoRepository.save(produto);

            EstoqueMovimento mov = new EstoqueMovimento();
            mov.setProduto(produto);
            mov.setTipo(TipoMovimento.SAIDA);
            mov.setQuantidade(item.getQuantidade());
            mov.setMotivo("Venda");
            mov.setCriadoEm(LocalDateTime.now());
            movimentoRepository.save(mov);
        }

        return vendaSalva;
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
