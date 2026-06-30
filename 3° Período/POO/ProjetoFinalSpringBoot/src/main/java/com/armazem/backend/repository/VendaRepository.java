package com.armazem.backend.repository;

import com.armazem.backend.dto.ProdutoTopVendaDTO;
import com.armazem.backend.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findTop5ByOrderByIdDesc();

    @Query("SELECT COALESCE(SUM(v.totalFinal), 0) FROM Venda v WHERE v.status = 'CONCLUIDA' "
            + "AND MONTH(v.criadoEm) = MONTH(CURRENT_DATE) AND YEAR(v.criadoEm) = YEAR(CURRENT_DATE)")
    BigDecimal calcularFaturamentoMensal();

    @Query("SELECT new com.armazem.backend.dto.ProdutoTopVendaDTO(i.produto.nome, SUM(i.quantidade)) "
            + "FROM VendaItem i WHERE i.venda.status = 'CONCLUIDA' "
            + "GROUP BY i.produto.id, i.produto.nome ORDER BY SUM(i.quantidade) DESC")
    List<ProdutoTopVendaDTO> findTopProdutosVendidos();
}
