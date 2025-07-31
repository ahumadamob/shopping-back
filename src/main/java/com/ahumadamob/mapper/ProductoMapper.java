package com.ahumadamob.mapper;

import com.ahumadamob.dto.ProductoRequestDto;
import com.ahumadamob.dto.ProductoResponseDto;
import com.ahumadamob.dto.CategoriaResponseDto;
import com.ahumadamob.entity.Producto;
import com.ahumadamob.entity.Categoria;
import java.util.List;
import com.ahumadamob.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public Producto toEntity(ProductoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        if (dto.getCategoriaIds() != null) {
            List<Categoria> categorias = dto.getCategoriaIds().stream()
                    .map(categoriaService::findById)
                    .toList();
            producto.setCategorias(categorias);
        }
        return producto;
    }

    public ProductoResponseDto toResponseDto(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoResponseDto dto = new ProductoResponseDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        List<CategoriaResponseDto> categorias = producto.getCategorias().stream()
                .map(categoriaMapper::toResponseDto)
                .toList();
        dto.setCategorias(categorias);
        return dto;
    }
}
