package com.ahumadamob.controller;

import com.ahumadamob.common.ResponseUtils;
import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.ProductoAtributoRequestDto;
import com.ahumadamob.dto.ProductoAtributoResponseDto;
import com.ahumadamob.entity.ProductoAtributo;
import com.ahumadamob.mapper.ProductoAtributoMapper;
import com.ahumadamob.service.IProductoAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto-atributos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoAtributoController {

    @Autowired
    private IProductoAtributoService productoAtributoService;

    @Autowired
    private ProductoAtributoMapper productoAtributoMapper;

    @GetMapping
    public ResponseEntity<ApiSuccessResponseDto<List<ProductoAtributoResponseDto>>> getAll() {
        List<ProductoAtributo> list = productoAtributoService.findAll();
        List<ProductoAtributoResponseDto> dtoList = list.stream()
                .map(productoAtributoMapper::toResponseDto)
                .toList();
        return ResponseUtils.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<ProductoAtributoResponseDto>> getById(@PathVariable Long id) {
        ProductoAtributo entity = productoAtributoService.findById(id);
        ProductoAtributoResponseDto dto = productoAtributoMapper.toResponseDto(entity);
        return ResponseUtils.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<ProductoAtributoResponseDto>> create(@Validated @RequestBody ProductoAtributoRequestDto request) {
        ProductoAtributo entity = productoAtributoMapper.toEntity(request);
        ProductoAtributo created = productoAtributoService.create(entity);
        ProductoAtributoResponseDto dto = productoAtributoMapper.toResponseDto(created);
        return ResponseUtils.created(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<ProductoAtributoResponseDto>> update(@PathVariable Long id, @Validated @RequestBody ProductoAtributoRequestDto request) {
        productoAtributoService.findById(id); // verify existence
        ProductoAtributo entity = productoAtributoMapper.toEntity(request);
        entity.setId(id);
        ProductoAtributo updated = productoAtributoService.update(entity);
        ProductoAtributoResponseDto dto = productoAtributoMapper.toResponseDto(updated);
        return ResponseUtils.updated(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Void>> delete(@PathVariable Long id) {
        productoAtributoService.findById(id); // verify existence
        productoAtributoService.deleteById(id);
        return ResponseUtils.deleted();
    }
}
