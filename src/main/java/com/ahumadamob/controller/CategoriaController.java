package com.ahumadamob.controller;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.CategoriaRequestDto;
import com.ahumadamob.dto.CategoriaResponseDto;
import com.ahumadamob.entity.Categoria;
import com.ahumadamob.mapper.CategoriaMapper;
import com.ahumadamob.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<ApiSuccessResponseDto<List<CategoriaResponseDto>>> getAll() {
        List<Categoria> categorias = categoriaService.findAll();
        List<CategoriaResponseDto> dtoList = categorias.stream()
                .map(categoriaMapper::toResponseDto)
                .toList();
        ApiSuccessResponseDto<List<CategoriaResponseDto>> response = ApiSuccessResponseDto.<List<CategoriaResponseDto>>builder()
                .message("Success")
                .data(dtoList)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<CategoriaResponseDto>> getById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        CategoriaResponseDto dto = categoriaMapper.toResponseDto(categoria);
        ApiSuccessResponseDto<CategoriaResponseDto> response = ApiSuccessResponseDto.<CategoriaResponseDto>builder()
                .message("Success")
                .data(dto)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<CategoriaResponseDto>> create(@Validated @RequestBody CategoriaRequestDto categoriaDto) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        Categoria creada = categoriaService.create(categoria);
        CategoriaResponseDto dto = categoriaMapper.toResponseDto(creada);
        ApiSuccessResponseDto<CategoriaResponseDto> response = ApiSuccessResponseDto.<CategoriaResponseDto>builder()
                .message("Created")
                .data(dto)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<CategoriaResponseDto>> update(@PathVariable Long id, @Validated @RequestBody CategoriaRequestDto categoriaDto) {
        categoriaService.findById(id); // verify existence
        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        categoria.setId(id);
        Categoria actualizada = categoriaService.update(categoria);
        CategoriaResponseDto dto = categoriaMapper.toResponseDto(actualizada);
        ApiSuccessResponseDto<CategoriaResponseDto> response = ApiSuccessResponseDto.<CategoriaResponseDto>builder()
                .message("Updated")
                .data(dto)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Void>> delete(@PathVariable Long id) {
        categoriaService.findById(id); // verify existence
        categoriaService.deleteById(id);
        ApiSuccessResponseDto<Void> response = ApiSuccessResponseDto.<Void>builder()
                .message("Deleted")
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
