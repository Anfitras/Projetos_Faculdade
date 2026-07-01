package com.armazem.backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Long id;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal desconto = BigDecimal.ZERO;
    private BigDecimal totalFinal = BigDecimal.ZERO;
    private FormaPagamento formaPagamento = FormaPagamento.DINHEIRO;
    private String observacao;
    private String status = "CONCLUIDA";
    private LocalDateTime criadoEm = LocalDateTime.now();
    private Cliente cliente;
    private List<VendaItem> itens = new ArrayList<>();

    public Venda() {
    }

    public Venda(Long id, BigDecimal total, BigDecimal desconto, BigDecimal totalFinal, FormaPagamento formaPagamento, String observacao, String status, LocalDateTime criadoEm, Cliente cliente, List<VendaItem> itens) {
        this.id = id;
        this.total = total;
        this.desconto = desconto;
        this.totalFinal = totalFinal;
        this.formaPagamento = formaPagamento;
        this.observacao = observacao;
        this.status = status;
        this.criadoEm = criadoEm;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(BigDecimal totalFinal) {
        this.totalFinal = totalFinal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }
}
