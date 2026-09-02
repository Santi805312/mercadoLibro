package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="notificacion")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Notificacion {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name="email_usuario", nullable=false) private String emailUsuario;
    @Column(name="isbn", nullable=false) private String isbn;
    @Column(name="email_propietario_id", nullable=false) private String emailPropietarioId;
    @Column(name="hora_de_publicacion", nullable=false) private LocalDateTime horaDePublicacion;
    @Enumerated(EnumType.STRING) @Column(name="tipo", nullable=false) private Enums.TipoNotificacion tipo;
    @Column(name="leida", nullable=false) private Boolean leida = false;
    @Column(name="archivada", nullable=false) private Boolean archivada = false;
    @Column(name="fecha_creacion", nullable=false) private LocalDateTime fechaCreacion;
}
