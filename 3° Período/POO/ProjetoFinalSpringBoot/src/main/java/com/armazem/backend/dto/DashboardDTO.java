package com.armazem.backend.dto;

import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
