package com.ingenieriaSoftware2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "intercambio_id", nullable = false)
    private Intercambio intercambio;

    @ManyToOne
    @JoinColumn(name = "usuario_autor_id", nullable = false)
    private Usuario autor; // quien escribe la reseña

    @ManyToOne
    @JoinColumn(name = "usuario_calificado_id", nullable = false)
    private Usuario calificado; // a quién se reseña

    @Column(nullable = false)
    private int calificacion;

    @Column(length = 500)
    private String comentario;

    private LocalDate fecha = LocalDate.now();

    @OneToMany(mappedBy = "reseña", cascade = CascadeType.ALL)
    private List<Notificacion> notificaciones = new ArrayList<>();
}
