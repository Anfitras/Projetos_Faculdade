package com.armazem.backend.repository;

import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.TipoMovimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface EstoqueMovimentoRepository extends JpaRepository<EstoqueMovimento, Long> {

    List<EstoqueMovimento> findTop5ByOrderByIdDesc();

    @Query("SELECT m FROM EstoqueMovimento m WHERE m.tipo = 'ENTRADA' AND m.dataValidade IS NOT NULL "
            + "AND m.dataValidade >= :hoje AND m.dataValidade <= :limite ORDER BY m.dataValidade ASC")
    List<EstoqueMovimento> findLotesProximosVencimento(@Param("hoje") LocalDate hoje, @Param("limite") LocalDate limite);

    @Query("SELECT COALESCE(SUM(m.quantidade * m.produto.precoCusto), 0) FROM EstoqueMovimento m "
            + "WHERE m.tipo = :tipo "
            + "AND MONTH(m.criadoEm) = MONTH(CURRENT_DATE) AND YEAR(m.criadoEm) = YEAR(CURRENT_DATE)")
    BigDecimal calcularGastoMensal(@Param("tipo") TipoMovimento tipo);
}
