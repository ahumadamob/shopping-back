package com.ahumadamob.mapper;

import com.ahumadamob.dto.CategoriaRequestDto;
import com.ahumadamob.entity.Categoria;

public class CategoriaMapper {

    public static Categoria toEntity(CategoriaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        if (dto.getParentId() != null) {
            Categoria parent = new Categoria();
            parent.setId(dto.getParentId());
            categoria.setParent(parent);
        }
        return categoria;
    }
}
