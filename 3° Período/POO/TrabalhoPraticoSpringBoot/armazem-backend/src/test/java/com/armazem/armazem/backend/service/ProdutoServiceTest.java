package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.Produto;
import com.armazem.armazem.backend.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    private Produto produto;

    @BeforeEach
    public void setup() {
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Arroz");
        produto.setPrecoCusto(new BigDecimal("15.00"));
        produto.setPrecoVenda(new BigDecimal("20.00"));
        produto.setEstoqueAtual(50);
    }

    @Test
    public void testSalvarProduto() {
        Mockito.when(produtoRepository.save(any(Produto.class))).thenReturn(produto);
        Produto salvo = produtoService.salvar(produto);
        assertNotNull(salvo);
        assertEquals("Arroz", salvo.getNome());
    }

    @Test
    public void testBuscarProdutoExistente() {
        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        Produto encontrado = produtoService.buscarPorId(1L);
        assertNotNull(encontrado);
        assertEquals(1L, encontrado.getId());
    }

    @Test
    public void testAtualizarProdutoInexistente() {
        Mockito.when(produtoRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> {
            produtoService.atualizar(99L, produto);
        });
    }
}
