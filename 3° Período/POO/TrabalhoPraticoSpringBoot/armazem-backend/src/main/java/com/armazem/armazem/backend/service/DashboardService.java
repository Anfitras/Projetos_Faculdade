package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.dto.DashboardDTO;
import com.armazem.armazem.backend.model.Produto;
import com.armazem.armazem.backend.repository.EstoqueMovimentoRepository;
import com.armazem.armazem.backend.repository.ProdutoRepository;
import com.armazem.armazem.backend.repository.VendaRepository;
import com.armazem.armazem.backend.repository.VendaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueMovimentoRepository movimentoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaItemRepository vendaItemRepository;

    public DashboardDTO obterDadosDashboard() {
        DashboardDTO dto = new DashboardDTO();
        List<Produto> produtos = produtoRepository.findAll();
        dto.setTotalProdutos(produtos.size());

        BigDecimal valorTotal = BigDecimal.ZERO;
        long produtosCriticos = 0;
        long quantidadeTotalFisica = 0;
        List<Produto> listaBaixoEstoque = new java.util.ArrayList<>();

        for (Produto p : produtos) {
            quantidadeTotalFisica += p.getEstoqueAtual();

            if (p.getEstoqueAtual() <= 20) {
                listaBaixoEstoque.add(p);
            }

            if (p.getEstoqueAtual() > 0) {
                BigDecimal qtd = new BigDecimal(p.getEstoqueAtual());
                valorTotal = valorTotal.add(p.getPrecoCusto().multiply(qtd));
            }
            if (p.getEstoqueAtual() < p.getEstoqueMinimo()) {
                produtosCriticos++;
            }
        }

        dto.setValorTotalEstoque(valorTotal);
        dto.setProdutosEstoqueCritico(produtosCriticos);
        dto.setUltimasMovimentacoes(movimentoRepository.findTop5ByOrderByIdDesc());
        dto.setQuantidadeTotalEstoque(quantidadeTotalFisica);
        dto.setProdutosBaixoEstoque(listaBaixoEstoque);

        BigDecimal fatMensal = vendaRepository.calcularFaturamentoMensal();
        dto.setFaturamentoMensal(fatMensal != null ? fatMensal : BigDecimal.ZERO);

        BigDecimal gastoMensal = movimentoRepository.calcularGastoMensal();
        dto.setGastoMensal(gastoMensal != null ? gastoMensal : BigDecimal.ZERO);

        dto.setTopProdutosVendidos(vendaItemRepository.findTopProdutosVendidos());

        dto.setUltimasVendas(vendaRepository.findTop5ByOrderByIdDesc());

        return dto;
    }
}
