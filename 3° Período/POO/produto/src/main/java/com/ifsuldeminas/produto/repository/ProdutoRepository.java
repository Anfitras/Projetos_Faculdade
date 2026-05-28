package com.ifsuldeminas.produto.repository;

import com.ifsuldeminas.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
