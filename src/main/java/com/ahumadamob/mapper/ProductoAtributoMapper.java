package com.ahumadamob.mapper;

import com.ahumadamob.dto.ProductoAtributoRequestDto;
import com.ahumadamob.dto.ProductoAtributoResponseDto;
import com.ahumadamob.entity.ProductoAtributo;
import com.ahumadamob.entity.Producto;
import com.ahumadamob.entity.CatalogoAtributo;
import com.ahumadamob.service.IProductoService;
import com.ahumadamob.service.ICatalogoAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoAtributoMapper {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICatalogoAtributoService catalogoAtributoService;

    @Autowired
    private CatalogoAtributoMapper catalogoAtributoMapper;

    public ProductoAtributo toEntity(ProductoAtributoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = productoService.findById(dto.getProductoId());
        CatalogoAtributo catalogo = catalogoAtributoService.findById(dto.getCatalogoAtributoId());
        ProductoAtributo entity = new ProductoAtributo();
        entity.setProducto(producto);
        entity.setCatalogoAtributo(catalogo);
        entity.setValor(dto.getValor());
        return entity;
    }

    public ProductoAtributoResponseDto toResponseDto(ProductoAtributo entity) {
        if (entity == null) {
            return null;
        }
        ProductoAtributoResponseDto dto = new ProductoAtributoResponseDto();
        dto.setId(entity.getId());
        dto.setProductoId(entity.getProducto().getId());
        dto.setCatalogoAtributo(catalogoAtributoMapper.toResponseDto(entity.getCatalogoAtributo()));
        dto.setValor(entity.getValor());
        return dto;
    }
}
