package com.ahumadamob.controller;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.ProductoRequestDto;
import com.ahumadamob.dto.ProductoResponseDto;
import com.ahumadamob.common.ResponseUtils;
import com.ahumadamob.entity.Producto;
import com.ahumadamob.mapper.ProductoMapper;
import com.ahumadamob.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ProductoMapper productoMapper;

    @GetMapping
    public ResponseEntity<ApiSuccessResponseDto<List<ProductoResponseDto>>> getAll() {
        List<Producto> productos = productoService.findAll();
        List<ProductoResponseDto> dtoList = productos.stream()
                .map(productoMapper::toResponseDto)
                .toList();
        return ResponseUtils.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<ProductoResponseDto>> getById(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        ProductoResponseDto dto = productoMapper.toResponseDto(producto);
        return ResponseUtils.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<ProductoResponseDto>> create(
            @Validated @RequestBody ProductoRequestDto productoDto) {
        Producto producto = productoMapper.toEntity(productoDto);
        Producto creado = productoService.create(producto);
        ProductoResponseDto dto = productoMapper.toResponseDto(creado);
        return ResponseUtils.created(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<ProductoResponseDto>> update(
            @PathVariable Long id,
            @Validated @RequestBody ProductoRequestDto productoDto) {
        productoService.findById(id); // verify existence
        Producto producto = productoMapper.toEntity(productoDto);
        producto.setId(id);
        Producto actualizado = productoService.update(producto);
        ProductoResponseDto dto = productoMapper.toResponseDto(actualizado);
        return ResponseUtils.updated(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Void>> delete(@PathVariable Long id) {
        productoService.findById(id); // verify existence
        productoService.deleteById(id);
        return ResponseUtils.deleted();
    }
}
