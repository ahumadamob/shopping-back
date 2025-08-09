package com.ahumadamob.entity;

import com.ahumadamob.common.DataType;
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

    @Column(name = "nombre", nullable = false, length = 64, unique = true)
    @NotBlank
    @Size(max = 64)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type", nullable = false, length = 20)
    @NotNull
    private DataType dataType;

    @Column(name = "unidad", length = 32)
    @Size(max = 32)
    private String unidad;

    @Column(name = "descripcion", length = 255)
    @Size(max = 255)
    private String descripcion;

    @Column(name = "orden")
    @Min(0)
    private Integer orden;

    @Column(name = "valor_min")
    private Double valorMin;

    @Column(name = "valor_max")
    private Double valorMax;

    @Column(name = "activo", nullable = false)
    @NotNull
    private Boolean activo;
}
