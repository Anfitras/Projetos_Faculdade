package com.armazem.armazem.backend.repository;

import com.armazem.armazem.backend.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @org.springframework.data.jpa.repository.Query(value = "SELECT SUM(total_final) FROM venda WHERE status = 'CONCLUIDA' AND MONTH(criado_em) = MONTH(CURRENT_DATE()) AND YEAR(criado_em) = YEAR(CURRENT_DATE())", nativeQuery = true)
    java.math.BigDecimal calcularFaturamentoMensal();

    List<Venda> findTop5ByOrderByIdDesc();
}
