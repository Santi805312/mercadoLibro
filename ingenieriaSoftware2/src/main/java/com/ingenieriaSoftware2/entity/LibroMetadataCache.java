package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="libro_metadata_cache", schema="public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LibroMetadataCache {
    @Id @Column(name="isbn", nullable=false) private String isbn;
    @Column(name="google_books_id", nullable=false, unique=true) private String googleBooksId;
    @Column(name="titulo", nullable=false) private String titulo;
    @Column(name="autores") private String autores;
    @Column(name="puntuacion_externa", precision=3, scale=2) private BigDecimal puntuacionExterna;
    @Column(name="fecha_cache_bibliografico") private LocalDateTime fechaCacheBibliografico;
    @Column(name="fecha_cache_puntuacion") private LocalDateTime fechaCachePuntuacion;
}
