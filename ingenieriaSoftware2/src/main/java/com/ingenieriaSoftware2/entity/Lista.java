package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="lista", schema="public") @IdClass(Lista.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Lista {
    @Id @Column(name="email_usuario", nullable=false) private String emailUsuario;
    @Id @Column(name="isbn", nullable=false) private String isbn;
    @Column(name="nota_privada") private String notaPrivada;
    @Column(name="precio_min", precision=10, scale=2) private BigDecimal precioMin;
    @Column(name="precio_max", precision=10, scale=2) private BigDecimal precioMax;
    @JdbcTypeCode(SqlTypes.ARRAY) @Column(name="condiciones_aceptables", columnDefinition="calidad_libro[]") private Enums.CalidadLibro[] condicionesAceptables;
    @Column(name="fecha_agregado", nullable=false) private LocalDateTime fechaAgregado;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailUsuario; String isbn; }
}
