package com.ahumadamob.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoAtributoRequestDto {

    @NotNull
    private Long productoId;

    @NotNull
    private Long catalogoAtributoId;

    @NotNull
    @Size(max = 255)
    private String valor;
}
