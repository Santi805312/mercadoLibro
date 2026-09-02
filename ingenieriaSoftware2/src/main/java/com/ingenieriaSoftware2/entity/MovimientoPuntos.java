package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity @Table(name="movimiento_puntos") @IdClass(MovimientoPuntos.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MovimientoPuntos {
    @Id @Column(name="isbn_solicitante", nullable=false) private String isbnSolicitante;
    @Id @Column(name="propietario_id_solicitante", nullable=false) private String propietarioIdSolicitante;
    @Id @Column(name="hora_de_publicacion_solicitante", nullable=false) private LocalDateTime horaDePublicacionSolicitante;
    @Id @Column(name="isbn_ofrecida", nullable=false) private String isbnOfrecida;
    @Id @Column(name="propietario_id_ofrecida", nullable=false) private String propietarioIdOfrecida;
    @Id @Column(name="hora_de_publicacion_ofrecida", nullable=false) private LocalDateTime horaDePublicacionOfrecida;
    @Id @Column(name="id_usuario", nullable=false) private String idUsuario;
    @Id @Enumerated(EnumType.STRING) @Column(name="tipo", nullable=false) private Enums.TipoMovimiento tipo;
    @Column(name="monto", nullable=false) private Long monto;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable {
        String isbnSolicitante; String propietarioIdSolicitante; LocalDateTime horaDePublicacionSolicitante; String isbnOfrecida; String propietarioIdOfrecida; LocalDateTime horaDePublicacionOfrecida; String idUsuario; Enums.TipoMovimiento tipo;
    }
}
