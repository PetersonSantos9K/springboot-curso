package com.petersonsantos9k.libraryapi.repository;

import com.petersonsantos9k.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
