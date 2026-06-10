package com.armazem.trabalhobancotdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    private Banco instance;

    @BeforeEach
    public void setUp() {
        instance = new Banco();
    }

    @Test
    public void testInicializacaoSaldo() {
        assertEquals(0.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testInicializacaoAtivacao() {
        assertTrue(instance.isAtivado());
    }

    @Test
    public void testAtivarContaJaAtivada() {
        assertFalse(instance.ativarConta());
        assertTrue(instance.isAtivado());
    }

    @Test
    public void testAtivarContaDesativada() {
        instance.desativarConta();
        assertTrue(instance.ativarConta());
        assertTrue(instance.isAtivado());
    }

    @Test
    public void testDesativarContaZeradaEAtiva() {
        assertTrue(instance.desativarConta());
        assertFalse(instance.isAtivado());
    }

    @Test
    public void testDesativarContaComSaldoPositivo() {
        instance.depositar(10.0f);
        assertFalse(instance.desativarConta());
        assertTrue(instance.isAtivado());
    }

    @Test
    public void testDesativarContaJaDesativada() {
        instance.desativarConta();
        assertFalse(instance.desativarConta());
        assertFalse(instance.isAtivado());
    }

    @Test
    public void testDesativarContaComSaldoNegativoForcado() {
        instance.setSaldo(-50.0f);
        assertFalse(instance.desativarConta());
        assertTrue(instance.isAtivado());
    }

    @Test
    public void testDepositarValorPositivo() {
        assertTrue(instance.depositar(150.50f));
        assertEquals(150.50f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testDepositarValorZero() {
        assertFalse(instance.depositar(0.0f));
        assertEquals(0.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testDepositarValorNegativo() {
        assertFalse(instance.depositar(-0.01f));
        assertFalse(instance.depositar(-100.0f));
        assertEquals(0.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testDepositarEmContaDesativada() {
        instance.desativarConta();
        assertFalse(instance.depositar(100.0f));
        assertEquals(0.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testDepositosMultiplosAcumulativos() {
        instance.depositar(10.5f);
        instance.depositar(20.25f);
        instance.depositar(5.25f);
        assertEquals(36.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testDepositoValorMaximoFloat() {
        assertTrue(instance.depositar(Float.MAX_VALUE));
        assertEquals(Float.MAX_VALUE, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSacarValorDisponivel() {
        instance.depositar(200.0f);
        assertTrue(instance.sacar(50.0f));
        assertEquals(150.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSacarSaldoExato() {
        instance.depositar(123.45f);
        assertTrue(instance.sacar(123.45f));
        assertEquals(0.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSacarValorAcimaDoSaldo() {
        instance.depositar(50.0f);
        assertFalse(instance.sacar(50.01f));
        assertEquals(50.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSacarValorZero() {
        instance.depositar(100.0f);
        assertFalse(instance.sacar(0.0f));
        assertEquals(100.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSacarValorNegativo() {
        instance.depositar(100.0f);
        assertFalse(instance.sacar(-50.0f));
        assertEquals(100.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSacarEmContaDesativada() {
        instance.depositar(100.0f);
        instance.setAtivado(false);
        assertFalse(instance.sacar(50.0f));
        assertEquals(100.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSaquesMultiplos() {
        instance.depositar(100.0f);
        instance.sacar(20.0f);
        instance.sacar(30.0f);
        assertEquals(50.0f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testPrecisaoDecimalSubtracao() {
        instance.depositar(10.0f);
        instance.sacar(9.9f);
        assertEquals(0.1f, instance.getSaldo(), 0.001f);
    }

    @Test
    public void testSetSaldoDireto() {
        instance.setSaldo(999.99f);
        assertEquals(999.99f, instance.getSaldo(), 0.0001f);
    }

    @Test
    public void testSetAtivadoDireto() {
        instance.setAtivado(false);
        assertFalse(instance.isAtivado());
        instance.setAtivado(true);
        assertTrue(instance.isAtivado());
    }

    @Test
    public void testToStringFormatoAtivado() {
        instance.depositar(50.0f);
        String esperado = "Banco{saldo=50.0, ativado=true}";
        assertEquals(esperado, instance.toString());
    }

    @Test
    public void testToStringFormatoDesativado() {
        instance.desativarConta();
        String esperado = "Banco{saldo=0.0, ativado=false}";
        assertEquals(esperado, instance.toString());
    }
}
