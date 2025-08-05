package com.ahumadamob.dto;

import com.ahumadamob.common.TipoDato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogoAtributoResponseDto {
    private Long id;
    private String nombre;
    private TipoDato tipoDato;
    private String unidad;
    private String descripcion;
    private Boolean activo;
}
