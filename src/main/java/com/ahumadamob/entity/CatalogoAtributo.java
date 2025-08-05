package com.ahumadamob.entity;

import com.ahumadamob.common.TipoDato;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "catalogo_atributos")
@Getter
@Setter
@NoArgsConstructor
public class CatalogoAtributo extends BaseEntity {

    @Column(name = "nombre", nullable = false, length = 64)
    @NotBlank
    @Size(max = 64)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_dato", nullable = false, length = 20)
    @NotNull
    private TipoDato tipoDato;

    @Column(name = "unidad", length = 32)
    @Size(max = 32)
    private String unidad;

    @Column(name = "descripcion", length = 255)
    @Size(max = 255)
    private String descripcion;

    @Column(name = "activo", nullable = false)
    @NotNull
    private Boolean activo;
}
