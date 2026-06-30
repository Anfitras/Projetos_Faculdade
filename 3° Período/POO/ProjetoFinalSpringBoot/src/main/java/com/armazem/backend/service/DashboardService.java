package com.armazem.backend.service;

import com.armazem.backend.dto.DashboardDTO;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.TipoMovimento;
import com.armazem.backend.repository.EstoqueMovimentoRepository;
import com.armazem.backend.repository.ProdutoRepository;
import com.armazem.backend.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueMovimentoRepository movimentoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public DashboardDTO obterDadosDashboard() {
        DashboardDTO dto = new DashboardDTO();
        List<Produto> produtos = produtoRepository.findAll();

        dto.setTotalProdutos(produtos.size());

        BigDecimal valorTotal = BigDecimal.ZERO;
        long produtosCriticos = 0;
        long quantidadeTotalFisica = 0;
        List<Produto> listaBaixoEstoque = new ArrayList<>();

        for (Produto p : produtos) {
            if (p.getEstoqueAtual() != null) {
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
        }

        dto.setValorTotalEstoque(valorTotal);
        dto.setProdutosEstoqueCritico(produtosCriticos);
        dto.setUltimasMovimentacoes(movimentoRepository.findTop5ByOrderByIdDesc());
        dto.setQuantidadeTotalEstoque(quantidadeTotalFisica);
        dto.setProdutosBaixoEstoque(listaBaixoEstoque);

        BigDecimal fatMensal = vendaRepository.calcularFaturamentoMensal();
        dto.setFaturamentoMensal(fatMensal != null ? fatMensal : BigDecimal.ZERO);

        BigDecimal gastoMensal = movimentoRepository.calcularGastoMensal(TipoMovimento.ENTRADA);
        dto.setGastoMensal(gastoMensal != null ? gastoMensal : BigDecimal.ZERO);

        dto.setTopProdutosVendidos(vendaRepository.findTopProdutosVendidos());
        dto.setUltimasVendas(vendaRepository.findTop5ByOrderByIdDesc());

        java.time.LocalDate hoje = java.time.LocalDate.now();
        dto.setProdutosProximosVencimento(
                movimentoRepository.findLotesProximosVencimento(hoje, hoje.plusDays(30)));

        return dto;
    }
}
