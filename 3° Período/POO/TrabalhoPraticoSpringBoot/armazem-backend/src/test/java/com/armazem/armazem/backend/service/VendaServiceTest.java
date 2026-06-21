package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.*;
import com.armazem.armazem.backend.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class VendaServiceTest {

    @Mock
    private VendaRepository vendaRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private EstoqueMovimentoRepository movimentoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private VendaService vendaService;

    private Venda venda;
    private Produto produto;
    private VendaItem item;

    @BeforeEach
    public void setup() {
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Feijao");
        produto.setPrecoVenda(new BigDecimal("10.00"));
        produto.setEstoqueAtual(100);

        item = new VendaItem();
        item.setProduto(produto);
        item.setQuantidade(2);

        venda = new Venda();
        venda.setId(1L);
        venda.setItens(new ArrayList<>());
        venda.getItens().add(item);
        venda.setDesconto(BigDecimal.ZERO);
        venda.setStatus("CONCLUIDA");
    }

    @Test
    public void testRegistrarVendaComSucesso() {
        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        Mockito.when(vendaRepository.save(any(Venda.class))).thenReturn(venda);

        Venda registrada = vendaService.registrarVenda(venda);

        assertNotNull(registrada);
        assertEquals(98, produto.getEstoqueAtual());
        Mockito.verify(movimentoRepository, Mockito.times(1)).save(any(EstoqueMovimento.class));
    }

    @Test
    public void testRegistrarVendaEstoqueInsuficiente() {
        item.setQuantidade(150);
        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            vendaService.registrarVenda(venda);
        });

        assertTrue(exception.getMessage().contains("Estoque insuficiente"));
        Mockito.verify(vendaRepository, Mockito.never()).save(any(Venda.class));
    }

    @Test
    public void testCancelarVendaComSucesso() {
        Mockito.when(vendaRepository.findById(1L)).thenReturn(Optional.of(venda));
        Mockito.when(vendaRepository.save(any(Venda.class))).thenReturn(venda);

        Venda cancelada = vendaService.cancelarVenda(1L);

        assertEquals("CANCELADA", cancelada.getStatus());
        assertEquals(102, produto.getEstoqueAtual());
        Mockito.verify(movimentoRepository, Mockito.times(1)).save(any(EstoqueMovimento.class));
    }

    @Test
    public void testCancelarVendaJaCancelada() {
        venda.setStatus("CANCELADA");
        Mockito.when(vendaRepository.findById(1L)).thenReturn(Optional.of(venda));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            vendaService.cancelarVenda(1L);
        });

        assertTrue(exception.getMessage().contains("já se encontra cancelada"));
    }
}
