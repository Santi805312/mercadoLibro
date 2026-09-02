package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="baneo", schema="public") @IdClass(Baneo.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Baneo {
    @Id @Column(name="email_reportante_id", nullable=false) private String emailReportanteId;
    @Id @Column(name="hora_reporte", nullable=false) private LocalDateTime horaReporte;
    @Id @Column(name="email_reportado_id", nullable=false) private String emailReportadoId;
    @Column(name="Fecha_inicio", nullable=false) private LocalDateTime fechaInicio;
    @Column(name="Fecha_fin") private LocalDateTime fechaFin;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailReportanteId; LocalDateTime horaReporte; String emailReportadoId; }
}
