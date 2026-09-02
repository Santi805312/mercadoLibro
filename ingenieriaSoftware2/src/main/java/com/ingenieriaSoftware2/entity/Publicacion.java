package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="publicacion", schema="public")
@IdClass(Publicacion.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Publicacion {
    @Id @Column(name="isbn", nullable=false) private String isbn;
    @Id @Column(name="email_propietario_id", nullable=false) private String emailPropietarioId;
    @Id @Column(name="hora_de_publicacion", nullable=false) private LocalDateTime horaDePublicacion;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="estado_fisico", nullable=false) private Enums.CalidadLibro estadoFisico;
    @Column(name="valor_puntos_solicitado", nullable=false, precision=10, scale=2) private BigDecimal valorPuntosSolicitado;
    @Column(name="valor_referencia_calculado", precision=10, scale=2) private BigDecimal valorReferenciaCalculado;
    @Column(name="comentario") private String comentario;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="estado", nullable=false) private Enums.EstadoPublicacion estado = Enums.EstadoPublicacion.DISPONIBLE;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="color_semaforo", nullable=false) private Enums.ColorSemaforo colorSemaforo = Enums.ColorSemaforo.SIN_REFERENCIA;

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class Id implements java.io.Serializable {
        private String isbn;
        private String emailPropietarioId;
        private LocalDateTime horaDePublicacion;
    }
}
