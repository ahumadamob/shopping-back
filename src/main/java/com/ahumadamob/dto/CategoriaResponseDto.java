package com.ahumadamob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaResponseDto {
    private Long id;
    private String nombre;
    private String path;
    private CategoriaResponseDto parent;
}
