package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="publicacion_historial_precio", schema="public") @IdClass(PublicacionHistorialPrecio.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PublicacionHistorialPrecio {
    @Id @Column(name="isbn", nullable=false) private String isbn;
    @Id @Column(name="email_propietario_id", nullable=false) private String emailPropietarioId;
    @Id @Column(name="hora_de_publicacion", nullable=false) private LocalDateTime horaDePublicacion;
    @Id @Column(name="fecha_cambio", nullable=false) private LocalDateTime fechaCambio;
    @Column(name="valor_puntos_anterior", nullable=false) private BigDecimal valorPuntosAnterior;
    @Column(name="valor_puntos_nuevo", nullable=false) private BigDecimal valorPuntosNuevo;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="color_anterior") private Enums.ColorSemaforo colorAnterior;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="color_nuevo") private Enums.ColorSemaforo colorNuevo;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String isbn; String emailPropietarioId; LocalDateTime horaDePublicacion; LocalDateTime fechaCambio; }
}
