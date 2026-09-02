package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="resena") @IdClass(Resena.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Resena {
    @Id private String isbnSolicitante; @Id private String propietarioIdSolicitante; @Id private LocalDateTime horaDePublicacionSolicitante; @Id private String isbnOfrecida; @Id private String propietarioIdOfrecida; @Id private LocalDateTime horaDePublicacionOfrecida;
    @Id @Column(name="email_reviewer") private String emailReviewer;
    @Column(nullable=false) private Short calificacion;
    private String comentario;
    @Enumerated(EnumType.STRING) private Enums.CalidadResena calidad;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String isbnSolicitante; String propietarioIdSolicitante; LocalDateTime horaDePublicacionSolicitante; String isbnOfrecida; String propietarioIdOfrecida; LocalDateTime horaDePublicacionOfrecida; String emailReviewer; }
}
