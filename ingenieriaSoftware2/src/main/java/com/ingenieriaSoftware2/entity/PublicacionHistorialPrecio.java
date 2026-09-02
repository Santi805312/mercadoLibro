package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="publicacion_historial_precio") @IdClass(PublicacionHistorialPrecio.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PublicacionHistorialPrecio {
    @Id private String isbn; @Id private String emailPropietarioId; @Id private LocalDateTime horaDePublicacion; @Id private LocalDateTime fechaCambio;
    @Column(name="valor_puntos_anterior", nullable=false, precision=19, scale=2) private BigDecimal valorPuntosAnterior;
    @Column(name="valor_puntos_nuevo", nullable=false, precision=19, scale=2) private BigDecimal valorPuntosNuevo;
    @Enumerated(EnumType.STRING) @Column(name="color_anterior") private Enums.ColorSemaforo colorAnterior;
    @Enumerated(EnumType.STRING) @Column(name="color_nuevo") private Enums.ColorSemaforo colorNuevo;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String isbn; String emailPropietarioId; LocalDateTime horaDePublicacion; LocalDateTime fechaCambio; }
}
