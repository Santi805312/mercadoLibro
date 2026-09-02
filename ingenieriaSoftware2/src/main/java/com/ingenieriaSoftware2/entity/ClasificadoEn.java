package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="CLASIFICADO_EN") @IdClass(ClasificadoEn.Id.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClasificadoEn {
    @Id private String isbn;
    @Id @Column(name="nombre_categoria") private String nombreCategoria;
    @Data @NoArgsConstructor @AllArgsConstructor public static class Id implements java.io.Serializable { String isbn; String nombreCategoria; }
}
