package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="compra") @IdClass(Compra.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Compra {
    @Id @Column(name="comprador_id", nullable=false) private String compradorId;
    @Id @Column(name="isbn", nullable=false) private String isbn;
    @Id @Column(name="propietario_id", nullable=false) private String propietarioId;
    @Id @Column(name="hora_de_publicacion", nullable=false) private LocalDateTime horaDePublicacion;
    @Column(name="puntos", nullable=false, precision=19, scale=2) private BigDecimal puntos;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String compradorId; String isbn; String propietarioId; LocalDateTime horaDePublicacion; }
}
