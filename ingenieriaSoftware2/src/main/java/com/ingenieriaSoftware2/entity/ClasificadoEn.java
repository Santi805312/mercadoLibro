package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="CLASIFICADO_EN", schema="public") @IdClass(ClasificadoEn.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClasificadoEn {
    @Id @Column(name="isbn", nullable=false) private String isbn;
    @Id @Column(name="nombre_categoria", nullable=false) private String nombreCategoria;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String isbn; String nombreCategoria; }
}
