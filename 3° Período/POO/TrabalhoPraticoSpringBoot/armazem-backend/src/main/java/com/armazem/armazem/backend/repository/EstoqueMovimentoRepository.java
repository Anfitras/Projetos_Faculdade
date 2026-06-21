package com.armazem.armazem.backend.repository;

import com.armazem.armazem.backend.model.EstoqueMovimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstoqueMovimentoRepository extends JpaRepository<EstoqueMovimento, Long> {

    List<EstoqueMovimento> findTop5ByOrderByIdDesc();

    @org.springframework.data.jpa.repository.Query(value = "SELECT SUM(em.quantidade * p.preco_custo) FROM estoque_movimento em JOIN produto p ON em.produto_id = p.id WHERE em.tipo = 'ENTRADA' AND MONTH(em.criado_em) = MONTH(CURRENT_DATE()) AND YEAR(em.criado_em) = YEAR(CURRENT_DATE())", nativeQuery = true)
    java.math.BigDecimal calcularGastoMensal();
}
