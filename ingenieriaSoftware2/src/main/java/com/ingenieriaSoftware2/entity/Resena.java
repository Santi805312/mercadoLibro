package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;

@Entity @Table(name="resena", schema="public") @IdClass(Resena.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Resena {
    @Id @Column(name="isbn_solicitante", nullable=false) private String isbnSolicitante;
    @Id @Column(name="propietario_id_solicitante", nullable=false) private String propietarioIdSolicitante;
    @Id @Column(name="hora_de_publicacion_solicitante", nullable=false) private LocalDateTime horaDePublicacionSolicitante;
    @Id @Column(name="isbn_ofrecida", nullable=false) private String isbnOfrecida;
    @Id @Column(name="propietario_id_ofrecida", nullable=false) private String propietarioIdOfrecida;
    @Id @Column(name="hora_de_publicacion_ofrecida", nullable=false) private LocalDateTime horaDePublicacionOfrecida;
    @Id @Column(name="email_reviewer", nullable=false) private String emailReviewer;
    @Column(name="calificacion", nullable=false) private Short calificacion;
    @Column(name="comentario") private String comentario;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="calidad") private Enums.CalidadResena calidad;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String isbnSolicitante; String propietarioIdSolicitante; LocalDateTime horaDePublicacionSolicitante; String isbnOfrecida; String propietarioIdOfrecida; LocalDateTime horaDePublicacionOfrecida; String emailReviewer; }
}
