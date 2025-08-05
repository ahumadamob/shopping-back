package com.ahumadamob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoAtributoResponseDto {
    private Long id;
    private Long productoId;
    private CatalogoAtributoResponseDto catalogoAtributo;
    private String valor;
}
