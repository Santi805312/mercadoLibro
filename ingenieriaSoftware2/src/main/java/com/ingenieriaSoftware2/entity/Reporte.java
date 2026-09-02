package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="reporte") @IdClass(Reporte.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reporte {
    @Id @Column(name="email_reportante_id") private String emailReportanteId;
    @Id @Column(name="hora_reporte") private LocalDateTime horaReporte;
    @Id @Column(name="email_reportado_id") private String emailReportadoId;
    @Enumerated(EnumType.STRING) @Column(name="entidad_tipo", nullable=false) private Enums.EntidadReporte entidadTipo;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private Enums.MotivoReporte motivo;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private Enums.EstadoReporte estado = Enums.EstadoReporte.PENDIENTE;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailReportanteId; LocalDateTime horaReporte; String emailReportadoId; }
}
