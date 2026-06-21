package com.armazem.armazem.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "estoque_movimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueMovimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoMovimento tipo;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(length = 50)
    private String lote;

    @Column(length = 100)
    private String motivo;

    @Column(length = 255)
    private String observacao;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();
}
