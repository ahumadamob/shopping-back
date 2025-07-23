package com.ahumadamob.controller;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.entity.Categoria;
import com.ahumadamob.dto.CategoriaRequestDto;
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
    public ResponseEntity<ApiSuccessResponseDto<List<Categoria>>> getAll() {
        List<Categoria> categorias = categoriaService.findAll();
        ApiSuccessResponseDto<List<Categoria>> response = ApiSuccessResponseDto.<List<Categoria>>builder()
                .message("Success")
                .data(categorias)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Categoria>> getById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        ApiSuccessResponseDto<Categoria> response = ApiSuccessResponseDto.<Categoria>builder()
                .message("Success")
                .data(categoria)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<Categoria>> create(@Validated @RequestBody CategoriaRequestDto categoriaDto) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        Categoria creada = categoriaService.create(categoria);
        ApiSuccessResponseDto<Categoria> response = ApiSuccessResponseDto.<Categoria>builder()
                .message("Created")
                .data(creada)
                .timestamp(java.time.LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Categoria>> update(@PathVariable Long id, @Validated @RequestBody CategoriaRequestDto categoriaDto) {
        categoriaService.findById(id); // verify existence
        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        categoria.setId(id);
        Categoria actualizada = categoriaService.update(categoria);
        ApiSuccessResponseDto<Categoria> response = ApiSuccessResponseDto.<Categoria>builder()
                .message("Updated")
                .data(actualizada)
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
