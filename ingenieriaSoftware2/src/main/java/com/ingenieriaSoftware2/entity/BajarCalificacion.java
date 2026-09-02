package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="bajar_calificacion", schema="public") @IdClass(BajarCalificacion.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BajarCalificacion {
    @Id @Column(name="email_reportante_id", nullable=false) private String emailReportanteId;
    @Id @Column(name="hora_reporte", nullable=false) private LocalDateTime horaReporte;
    @Id @Column(name="email_reportado_id", nullable=false) private String emailReportadoId;
    @Column(name="Castigo") private Short castigo;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailReportanteId; LocalDateTime horaReporte; String emailReportadoId; }
}
