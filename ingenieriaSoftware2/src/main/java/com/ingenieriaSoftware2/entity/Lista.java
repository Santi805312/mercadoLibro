package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="lista") @IdClass(Lista.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Lista {
    @Id @Column(name="email_usuario") private String emailUsuario;
    @Id private String isbn;
    @Column(name="nota_privada") private String notaPrivada;
    @Column(name="precio_min", precision=19, scale=2) private BigDecimal precioMin;
    @Column(name="precio_max", precision=19, scale=2) private BigDecimal precioMax;
    @Enumerated(EnumType.STRING) @Column(name="condiciones_aceptables") private Enums.CalidadLibro[] condicionesAceptables;
    @Column(name="fecha_agregado", nullable=false) private LocalDateTime fechaAgregado;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String emailUsuario; String isbn; }
}
