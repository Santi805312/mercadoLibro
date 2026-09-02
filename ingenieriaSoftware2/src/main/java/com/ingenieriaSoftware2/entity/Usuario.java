package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "usuario", schema = "public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id @Column(name="email", nullable=false) private String email;
    @Column(name="nombre_usuario", nullable=false) private String nombreUsuario;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="rol", nullable=false) private Enums.RolUsuario rol;
    @Column(name="saldo_total", nullable=false, precision=12, scale=2) private BigDecimal saldoTotal = BigDecimal.ZERO;
    @Column(name="saldo_reservado", nullable=false, precision=12, scale=2) private BigDecimal saldoReservado = BigDecimal.ZERO;
    @Column(name="reputacion_promedio", precision=3, scale=2) private BigDecimal reputacionPromedio;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="estado_cuenta", nullable=false) private Enums.EstadoCuenta estadoCuenta = Enums.EstadoCuenta.ACTIVA;
    @Column(name="notificacion_email", nullable=false) private Boolean notificacionEmail = true;
    @Column(name="notificacion_inapp", nullable=false) private Boolean notificacionInapp = true;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="frecuencia_notificacion", nullable=false) private Enums.FrecuenciaNotificacion frecuenciaNotificacion = Enums.FrecuenciaNotificacion.INSTANTANEA;
    @Column(name="hora_resumen_diario") private LocalTime horaResumenDiario;
}
