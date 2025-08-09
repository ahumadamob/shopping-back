package com.ahumadamob.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto_atributos")
@Getter
@Setter
@NoArgsConstructor
public class ProductoAtributo extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @NotNull
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "catalogo_atributo_id", nullable = false)
    @NotNull
    private CatalogoAtributo catalogoAtributo;

    @Column(name = "valor", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    private String valor;
}
