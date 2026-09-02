package com.ingenieriaSoftware2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="categoria", schema="public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Categoria {
    @Id @Column(name="nombre", nullable=false) private String nombre;
    @Column(name="categoria_padre_id") private String categoriaPadreId;
}
