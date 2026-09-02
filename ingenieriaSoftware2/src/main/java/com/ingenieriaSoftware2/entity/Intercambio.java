package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="intercambio", schema="public") @IdClass(Intercambio.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Intercambio {
    @Id @Column(name="isbn_solicitante", nullable=false) private String isbnSolicitante;
    @Id @Column(name="propietario_id_solicitante", nullable=false) private String propietarioIdSolicitante;
    @Id @Column(name="hora_de_publicacion_solicitante", nullable=false) private LocalDateTime horaDePublicacionSolicitante;
    @Id @Column(name="isbn_ofrecida", nullable=false) private String isbnOfrecida;
    @Id @Column(name="propietario_id_ofrecida", nullable=false) private String propietarioIdOfrecida;
    @Id @Column(name="hora_de_publicacion_ofrecida", nullable=false) private LocalDateTime horaDePublicacionOfrecida;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="tipo", nullable=false) private Enums.TipoIntercambio tipo;
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) @Enumerated(EnumType.STRING) @Column(name="estado", nullable=false) private Enums.EstadoIntercambio estado;
    @Column(name="puntos_comprometidos", nullable=false, precision=10, scale=2) private BigDecimal puntosComprometidos = BigDecimal.ZERO;

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class Id implements java.io.Serializable {
        private String isbnSolicitante; private String propietarioIdSolicitante; private LocalDateTime horaDePublicacionSolicitante;
        private String isbnOfrecida; private String propietarioIdOfrecida; private LocalDateTime horaDePublicacionOfrecida;
    }
}
