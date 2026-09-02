package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="cadena") @IdClass(Cadena.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cadena {
    @Id private String isbnSolicitanteAnterior; @Id private String propietarioIdSolicitanteAnterior; @Id private LocalDateTime horaDePublicacionSolicitanteAnterior; @Id private String isbnOfrecidaAnterior; @Id private String propietarioIdOfrecidaAnterior; @Id private LocalDateTime horaDePublicacionOfrecidaAnterior;
    @Id private String isbnSolicitanteSiguiente; @Id private String propietarioIdSolicitanteSiguiente; @Id private LocalDateTime horaDePublicacionSolicitanteSiguiente; @Id private String isbnOfrecidaSiguiente; @Id private String propietarioIdOfrecidaSiguiente; @Id private LocalDateTime horaDePublicacionOfrecidaSiguiente;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private Enums.EstadoCadena estado = Enums.EstadoCadena.ACTIVA;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable {
        String isbnSolicitanteAnterior; String propietarioIdSolicitanteAnterior; LocalDateTime horaDePublicacionSolicitanteAnterior; String isbnOfrecidaAnterior; String propietarioIdOfrecidaAnterior; LocalDateTime horaDePublicacionOfrecidaAnterior; String isbnSolicitanteSiguiente; String propietarioIdSolicitanteSiguiente; LocalDateTime horaDePublicacionSolicitanteSiguiente; String isbnOfrecidaSiguiente; String propietarioIdOfrecidaSiguiente; LocalDateTime horaDePublicacionOfrecidaSiguiente;
    }
}
