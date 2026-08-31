package com.ingenieriaSoftware2.Repository;

import com.ingenieriaSoftware2.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibroRepository extends JpaRepository<Libro, UUID> {
}
