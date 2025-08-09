package com.ahumadamob.controller;

import com.ahumadamob.common.ResponseUtils;
import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.CatalogoAtributoRequestDto;
import com.ahumadamob.dto.CatalogoAtributoResponseDto;
import com.ahumadamob.entity.CatalogoAtributo;
import com.ahumadamob.mapper.CatalogoAtributoMapper;
import com.ahumadamob.service.ICatalogoAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo-atributos")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogoAtributoController {

    @Autowired
    private ICatalogoAtributoService catalogoAtributoService;

    @Autowired
    private CatalogoAtributoMapper catalogoAtributoMapper;

    @GetMapping
    public ResponseEntity<ApiSuccessResponseDto<List<CatalogoAtributoResponseDto>>> getAll() {
        List<CatalogoAtributo> list = catalogoAtributoService.findAll();
        List<CatalogoAtributoResponseDto> dtoList = list.stream()
                .map(catalogoAtributoMapper::toResponseDto)
                .toList();
        return ResponseUtils.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<CatalogoAtributoResponseDto>> getById(@PathVariable Long id) {
        CatalogoAtributo entity = catalogoAtributoService.findById(id);
        CatalogoAtributoResponseDto dto = catalogoAtributoMapper.toResponseDto(entity);
        return ResponseUtils.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<CatalogoAtributoResponseDto>> create(@Validated @RequestBody CatalogoAtributoRequestDto request) {
        CatalogoAtributo entity = catalogoAtributoMapper.toEntity(request);
        CatalogoAtributo created = catalogoAtributoService.create(entity);
        CatalogoAtributoResponseDto dto = catalogoAtributoMapper.toResponseDto(created);
        return ResponseUtils.created(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<CatalogoAtributoResponseDto>> update(@PathVariable Long id, @Validated @RequestBody CatalogoAtributoRequestDto request) {
        catalogoAtributoService.findById(id); // verify existence
        CatalogoAtributo entity = catalogoAtributoMapper.toEntity(request);
        entity.setId(id);
        CatalogoAtributo updated = catalogoAtributoService.update(entity);
        CatalogoAtributoResponseDto dto = catalogoAtributoMapper.toResponseDto(updated);
        return ResponseUtils.updated(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Void>> delete(@PathVariable Long id) {
        catalogoAtributoService.findById(id); // verify existence
        catalogoAtributoService.deleteById(id);
        return ResponseUtils.deleted();
    }
}
