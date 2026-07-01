package com.armazem.backend.dto;

import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.Venda;

import java.math.BigDecimal;
import java.util.List;

public class DashboardDTO {

    private long totalProdutos;
    private BigDecimal valorTotalEstoque;
    private long produtosEstoqueCritico;
    private List<EstoqueMovimento> ultimasMovimentacoes;
    private BigDecimal faturamentoMensal;
    private BigDecimal gastoMensal;
    private List<ProdutoTopVendaDTO> topProdutosVendidos;
    private Long quantidadeTotalEstoque;
    private List<Produto> produtosBaixoEstoque;
    private List<Venda> ultimasVendas;
    private List<EstoqueMovimento> produtosProximosVencimento;

    public DashboardDTO() {
    }

    public DashboardDTO(long totalProdutos, BigDecimal valorTotalEstoque, long produtosEstoqueCritico,
            List<EstoqueMovimento> ultimasMovimentacoes, BigDecimal faturamentoMensal, BigDecimal gastoMensal,
            List<ProdutoTopVendaDTO> topProdutosVendidos, Long quantidadeTotalEstoque,
            List<Produto> produtosBaixoEstoque, List<Venda> ultimasVendas,
            List<EstoqueMovimento> produtosProximosVencimento) {
        this.totalProdutos = totalProdutos;
        this.valorTotalEstoque = valorTotalEstoque;
        this.produtosEstoqueCritico = produtosEstoqueCritico;
        this.ultimasMovimentacoes = ultimasMovimentacoes;
        this.faturamentoMensal = faturamentoMensal;
        this.gastoMensal = gastoMensal;
        this.topProdutosVendidos = topProdutosVendidos;
        this.quantidadeTotalEstoque = quantidadeTotalEstoque;
        this.produtosBaixoEstoque = produtosBaixoEstoque;
        this.ultimasVendas = ultimasVendas;
        this.produtosProximosVencimento = produtosProximosVencimento;
    }

    public long getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(long totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public BigDecimal getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public void setValorTotalEstoque(BigDecimal valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }

    public long getProdutosEstoqueCritico() {
        return produtosEstoqueCritico;
    }

    public void setProdutosEstoqueCritico(long produtosEstoqueCritico) {
        this.produtosEstoqueCritico = produtosEstoqueCritico;
    }

    public List<EstoqueMovimento> getUltimasMovimentacoes() {
        return ultimasMovimentacoes;
    }

    public void setUltimasMovimentacoes(List<EstoqueMovimento> ultimasMovimentacoes) {
        this.ultimasMovimentacoes = ultimasMovimentacoes;
    }

    public BigDecimal getFaturamentoMensal() {
        return faturamentoMensal;
    }

    public void setFaturamentoMensal(BigDecimal faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }

    public BigDecimal getGastoMensal() {
        return gastoMensal;
    }

    public void setGastoMensal(BigDecimal gastoMensal) {
        this.gastoMensal = gastoMensal;
    }

    public List<ProdutoTopVendaDTO> getTopProdutosVendidos() {
        return topProdutosVendidos;
    }

    public void setTopProdutosVendidos(List<ProdutoTopVendaDTO> topProdutosVendidos) {
        this.topProdutosVendidos = topProdutosVendidos;
    }

    public Long getQuantidadeTotalEstoque() {
        return quantidadeTotalEstoque;
    }

    public void setQuantidadeTotalEstoque(Long quantidadeTotalEstoque) {
        this.quantidadeTotalEstoque = quantidadeTotalEstoque;
    }

    public List<Produto> getProdutosBaixoEstoque() {
        return produtosBaixoEstoque;
    }

    public void setProdutosBaixoEstoque(List<Produto> produtosBaixoEstoque) {
        this.produtosBaixoEstoque = produtosBaixoEstoque;
    }

    public List<Venda> getUltimasVendas() {
        return ultimasVendas;
    }

    public void setUltimasVendas(List<Venda> ultimasVendas) {
        this.ultimasVendas = ultimasVendas;
    }

    public List<EstoqueMovimento> getProdutosProximosVencimento() {
        return produtosProximosVencimento;
    }

    public void setProdutosProximosVencimento(List<EstoqueMovimento> produtosProximosVencimento) {
        this.produtosProximosVencimento = produtosProximosVencimento;
    }
}
