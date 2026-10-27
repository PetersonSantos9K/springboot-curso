package com.petersonsantos9k.libraryapi.repository;

import com.petersonsantos9k.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
