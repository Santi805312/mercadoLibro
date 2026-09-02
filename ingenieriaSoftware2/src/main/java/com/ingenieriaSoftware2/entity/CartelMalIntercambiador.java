package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="cartel_mal_intercambiador") @IdClass(CartelMalIntercambiador.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CartelMalIntercambiador {
    @Id @Column(name="email_reportante_id") private String emailReportanteId;
    @Id @Column(name="hora_reporte") private LocalDateTime horaReporte;
    @Id @Column(name="email_reportado_id") private String emailReportadoId;
    @Column(name="Cartel", nullable=false) private Boolean cartel = true;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailReportanteId; LocalDateTime horaReporte; String emailReportadoId; }
}
