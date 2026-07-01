package com.armazem.backend.service;

import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.TipoMovimento;
import com.armazem.backend.repository.EstoqueMovimentoRepository;
import com.armazem.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstoqueMovimentoService {

    @Autowired
    private EstoqueMovimentoRepository movimentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<EstoqueMovimento> listarTodos() {
        return movimentoRepository.findAll();
    }

    @Transactional
    public EstoqueMovimento registrarMovimento(EstoqueMovimento movimento) {
        Produto produto = produtoRepository.findById(movimento.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (movimento.getTipo() == TipoMovimento.ENTRADA) {
            produto.setEstoqueAtual(produto.getEstoqueAtual() + movimento.getQuantidade());
        } else if (movimento.getTipo() == TipoMovimento.SAIDA) {
            if (produto.getEstoqueAtual() < movimento.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente");
            }
            produto.setEstoqueAtual(produto.getEstoqueAtual() - movimento.getQuantidade());
        }

        produto.setAtualizadoEm(LocalDateTime.now());
        produtoRepository.save(produto);

        movimento.setProduto(produto);
        movimento.setCriadoEm(LocalDateTime.now());
        return movimentoRepository.save(movimento);
    }
}
