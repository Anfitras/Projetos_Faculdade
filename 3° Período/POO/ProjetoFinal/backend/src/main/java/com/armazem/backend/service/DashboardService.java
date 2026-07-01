package com.armazem.backend.service;

import com.armazem.backend.dto.DashboardDTO;
import com.armazem.backend.model.Produto;
import com.armazem.backend.repository.EstoqueMovimentoDAO;
import com.armazem.backend.repository.ProdutoDAO;
import com.armazem.backend.repository.VendaDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DashboardService {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final EstoqueMovimentoDAO movimentoDAO = new EstoqueMovimentoDAO();
    private final VendaDAO vendaDAO = new VendaDAO();

    public DashboardDTO obterDadosDashboard() {
        DashboardDTO dto = new DashboardDTO();
        List<Produto> produtos = produtoDAO.findAll();

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
        dto.setUltimasMovimentacoes(movimentoDAO.findTop5());
        dto.setQuantidadeTotalEstoque(quantidadeTotalFisica);
        dto.setProdutosBaixoEstoque(listaBaixoEstoque);

        BigDecimal fatMensal = vendaDAO.calcularFaturamentoMensal();
        dto.setFaturamentoMensal(fatMensal != null ? fatMensal : BigDecimal.ZERO);

        BigDecimal gastoMensal = movimentoDAO.calcularGastoMensal();
        dto.setGastoMensal(gastoMensal != null ? gastoMensal : BigDecimal.ZERO);

        dto.setTopProdutosVendidos(vendaDAO.findTopProdutosVendidos());
        dto.setUltimasVendas(vendaDAO.findTop5());
        dto.setProdutosProximosVencimento(movimentoDAO.findLotesProximosVencimento());

        return dto;
    }
}
