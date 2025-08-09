package com.ahumadamob.dto;

import com.ahumadamob.common.DataType;
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
    private DataType dataType;

    @Size(max = 32)
    private String unidad;

    @Size(max = 255)
    private String descripcion;

    @PositiveOrZero
    private Integer orden;

    private Double valorMin;

    private Double valorMax;

    @NotNull
    private Boolean activo;

    @AssertTrue(message = "valorMin debe ser menor o igual que valorMax")
    public boolean isValidRange() {
        return valorMin == null || valorMax == null || valorMin <= valorMax;
    }
}
