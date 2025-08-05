package com.ahumadamob.mapper;

import com.ahumadamob.dto.CatalogoAtributoRequestDto;
import com.ahumadamob.dto.CatalogoAtributoResponseDto;
import com.ahumadamob.entity.CatalogoAtributo;
import org.springframework.stereotype.Component;

@Component
public class CatalogoAtributoMapper {

    public CatalogoAtributo toEntity(CatalogoAtributoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        CatalogoAtributo entity = new CatalogoAtributo();
        entity.setNombre(dto.getNombre());
        entity.setDataType(dto.getDataType());
        entity.setUnidad(dto.getUnidad());
        entity.setDescripcion(dto.getDescripcion());
        entity.setActivo(dto.getActivo());
        return entity;
    }

    public CatalogoAtributoResponseDto toResponseDto(CatalogoAtributo entity) {
        if (entity == null) {
            return null;
        }
        CatalogoAtributoResponseDto dto = new CatalogoAtributoResponseDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDataType(entity.getDataType());
        dto.setUnidad(entity.getUnidad());
        dto.setDescripcion(entity.getDescripcion());
        dto.setActivo(entity.getActivo());
        return dto;
    }
}
