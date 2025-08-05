package com.ahumadamob.dto;

import com.ahumadamob.common.TipoDato;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogoAtributoRequestDto {

    @NotBlank
    @Size(max = 64)
    private String nombre;

    @NotNull
    private TipoDato tipoDato;

    @Size(max = 32)
    private String unidad;

    @Size(max = 255)
    private String descripcion;

    @NotNull
    private Boolean activo;
}
