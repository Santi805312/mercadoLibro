package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="baneo") @IdClass(Baneo.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Baneo {
    @Id @Column(name="email_reportante_id") private String emailReportanteId;
    @Id @Column(name="hora_reporte") private LocalDateTime horaReporte;
    @Id @Column(name="email_reportado_id") private String emailReportadoId;
    @Column(name="Fecha_inicio", nullable=false) private LocalDateTime fechaInicio;
    @Column(name="Fecha_fin") private LocalDateTime fechaFin;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailReportanteId; LocalDateTime horaReporte; String emailReportadoId; }
}
