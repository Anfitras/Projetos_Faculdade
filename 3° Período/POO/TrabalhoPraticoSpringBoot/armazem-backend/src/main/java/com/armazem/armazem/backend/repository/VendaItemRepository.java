package com.armazem.armazem.backend.repository;

import com.armazem.armazem.backend.model.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, Long> {

    @org.springframework.data.jpa.repository.Query("SELECT new com.armazem.armazem.backend.dto.ProdutoTopVendaDTO(p.nome, SUM(vi.quantidade)) FROM VendaItem vi JOIN vi.produto p JOIN vi.venda v WHERE v.status = 'CONCLUIDA' GROUP BY p.id, p.nome ORDER BY SUM(vi.quantidade) DESC")
    java.util.List<com.armazem.armazem.backend.dto.ProdutoTopVendaDTO> findTopProdutosVendidos();
}
