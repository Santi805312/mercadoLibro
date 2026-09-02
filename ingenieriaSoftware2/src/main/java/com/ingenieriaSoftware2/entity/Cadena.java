package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;

@Entity @Table(name="cadena", schema="public") @IdClass(Cadena.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cadena {
    @Id @Column(name="isbn_solicitante_anterior", nullable=false) private String isbnSolicitanteAnterior;
    @Id @Column(name="propietario_id_solicitante_anterior", nullable=false) private String propietarioIdSolicitanteAnterior;
    @Id @Column(name="hora_de_publicacion_solicitante_anterior", nullable=false) private LocalDateTime horaDePublicacionSolicitanteAnterior;
    @Id @Column(name="isbn_ofrecida_anterior", nullable=false) private String isbnOfrecidaAnterior;
    @Id @Column(name="propietario_id_ofrecida_anterior", nullable=false) private String propietarioIdOfrecidaAnterior;
    @Id @Column(name="hora_de_publicacion_ofrecida_anterior", nullable=false) private LocalDateTime horaDePublicacionOfrecidaAnterior;
    @Id @Column(name="isbn_solicitante_siguiente", nullable=false) private String isbnSolicitanteSiguiente;
    @Id @Column(name="propietario_id_solicitante_siguiente", nullable=false) private String propietarioIdSolicitanteSiguiente;
    @Id @Column(name="hora_de_publicacion_solicitante_siguiente", nullable=false) private LocalDateTime horaDePublicacionSolicitanteSiguiente;
    @Id @Column(name="isbn_ofrecida_siguiente", nullable=false) private String isbnOfrecidaSiguiente;
    @Id @Column(name="propietario_id_ofrecida_siguiente", nullable=false) private String propietarioIdOfrecidaSiguiente;
    @Id @Column(name="hora_de_publicacion_ofrecida_siguiente", nullable=false) private LocalDateTime horaDePublicacionOfrecidaSiguiente;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="estado", nullable=false) private Enums.EstadoCadena estado = Enums.EstadoCadena.ACTIVA;

    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable {
        String isbnSolicitanteAnterior; String propietarioIdSolicitanteAnterior; LocalDateTime horaDePublicacionSolicitanteAnterior; String isbnOfrecidaAnterior; String propietarioIdOfrecidaAnterior; LocalDateTime horaDePublicacionOfrecidaAnterior; String isbnSolicitanteSiguiente; String propietarioIdSolicitanteSiguiente; LocalDateTime horaDePublicacionSolicitanteSiguiente; String isbnOfrecidaSiguiente; String propietarioIdOfrecidaSiguiente; LocalDateTime horaDePublicacionOfrecidaSiguiente;
    }
}
