package com.petersonsantos9k.libraryapi.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro", schema = "public")
@Data
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, length = 30)
    private GeneroLivro genero;

    @Column(name="preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false, updatable = false)
    private Autor autor;

}




/*
CREATE TABLE livro(
        id UUID NOT NULL PRIMARY KEY,
        isbn VARCHAR(20) NOT NULL,
        titulo VARCHAR(150) NOT NULL,
        data_publicacao DATE NOT NULL,
        genero VARCHAR(30) NOT NULL,
        preco NUMERIC(18, 2),
        id_autor UUID NOT NULL REFERENCES autor(id),

        CONSTRAINT chk_genero CHECK (genero in ('FICCAO', 'FANTASIA', 'MISTERIO', 'ROMANCE', 'BIOGRAFIA', 'CIENCIA'))
        )

 */