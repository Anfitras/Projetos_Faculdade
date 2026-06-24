package com.armazem.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EstoqueMovimento {

    private Long id;
    private Produto produto;
    private TipoMovimento tipo;
    private Integer quantidade;
    private LocalDate dataValidade;
    private String lote;
    private String motivo;
    private String observacao;
    private LocalDateTime criadoEm = LocalDateTime.now();

    public EstoqueMovimento() {
    }

    public EstoqueMovimento(Long id, Produto produto, TipoMovimento tipo, Integer quantidade, LocalDate dataValidade, String lote, String motivo, String observacao, LocalDateTime criadoEm) {
        this.id = id;
        this.produto = produto;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.lote = lote;
        this.motivo = motivo;
        this.observacao = observacao;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoMovimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimento tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
