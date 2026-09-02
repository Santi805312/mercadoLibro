package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;

@Entity @Table(name="reporte", schema="public") @IdClass(Reporte.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reporte {
    @Id @Column(name="email_reportante_id", nullable=false) private String emailReportanteId;
    @Id @Column(name="hora_reporte", nullable=false) private LocalDateTime horaReporte;
    @Id @Column(name="email_reportado_id", nullable=false) private String emailReportadoId;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="entidad_tipo", nullable=false) private Enums.EntidadReporte entidadTipo;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="motivo", nullable=false) private Enums.MotivoReporte motivo;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="estado", nullable=false) private Enums.EstadoReporte estado = Enums.EstadoReporte.PENDIENTE;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailReportanteId; LocalDateTime horaReporte; String emailReportadoId; }
}
