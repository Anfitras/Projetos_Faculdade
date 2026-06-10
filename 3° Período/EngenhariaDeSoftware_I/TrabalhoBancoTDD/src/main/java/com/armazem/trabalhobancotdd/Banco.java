package com.armazem.trabalhobancotdd;

public class Banco {

    private float saldo;
    private boolean ativado;

    public Banco() {
        this.saldo = 0;
        this.ativado = true;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    public boolean ativarConta() {
        if (!this.isAtivado()) {
            this.setAtivado(true);
            return true;
        }
        return false;
    }

    public boolean desativarConta() {
        if (this.isAtivado() && this.getSaldo() == 0) {
            this.setAtivado(false);
            return true;
        }
        return false;
    }

    public boolean depositar(float valor) {
        if (this.isAtivado() && valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
        return false;
    }

    public boolean sacar(float valor) {
        if (this.isAtivado() && valor > 0 && this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Banco{" + "saldo=" + saldo + ", ativado=" + ativado + '}';
    }

}
