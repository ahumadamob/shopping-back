package com.ahumadamob.mapper;

import com.ahumadamob.dto.CategoriaRequestDto;
import com.ahumadamob.entity.Categoria;
import com.ahumadamob.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Maps {@link CategoriaRequestDto} to {@link Categoria} entities.
 */
@Component
public class CategoriaMapper {

    @Autowired
    private ICategoriaService categoriaService;

    public Categoria toEntity(CategoriaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        if (dto.getParentId() != null) {
            Categoria parent = categoriaService.findById(dto.getParentId());
            categoria.setParent(parent);
        }
        return categoria;
    }
}
