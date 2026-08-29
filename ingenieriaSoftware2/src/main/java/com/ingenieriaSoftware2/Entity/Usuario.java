package com.ingenieriaSoftware2.Entity;

import com.ingenieriaSoftware2.Entity.Libro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer saldoTotal;

    @Column(nullable = false)
    private Integer saldoReservado;

    @Column(nullable = false)
    private Integer reputacionPromedio;

    @OneToMany(mappedBy = "propietario")
    private List<Libro> libros = new ArrayList<>();

    @OneToMany(mappedBy = "prestador")
    private List<Intercambio> intercambiosRealizados = new ArrayList<>();

    @OneToMany(mappedBy = "receptor")
    private List<Intercambio> intercambiosRecibidos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<OfertaIntercambio> ofertas = new ArrayList<>();

    @ManyToMany(mappedBy = "participantes")
    private Set<CadenaIntercambio> cadenas = new HashSet<>();

    @OneToMany(mappedBy = "autor")
    private List<Resenia> reseniasEscritas = new ArrayList<>();

    @OneToMany(mappedBy = "calificado")
    private List<Resenia> reseniasRecibidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovimientoPuntos> movimientosPuntos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notificacion> notificaciones = new ArrayList<>();

}
