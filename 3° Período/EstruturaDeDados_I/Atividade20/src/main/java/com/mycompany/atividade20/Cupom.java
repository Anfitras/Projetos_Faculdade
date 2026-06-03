package com.mycompany.atividade20;

import java.time.LocalDate;

public class Cupom {

    private long codigo;
    private double desconto;
    private LocalDate dataValidade;

    public Cupom(long codigo, double desconto, LocalDate dataValidade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.dataValidade = dataValidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Cupom{"
                + "codigo=" + codigo
                + ", desconto=" + String.format("%.2f", desconto) + "% "
                + " dataValidade= " + dataValidade + "}";
    }

}
