package com.ahumadamob.controller;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.PictureGalleryRequestDto;
import com.ahumadamob.dto.PictureGalleryResponseDto;
import com.ahumadamob.common.ResponseUtils;
import com.ahumadamob.entity.PictureGallery;
import com.ahumadamob.mapper.PictureGalleryMapper;
import com.ahumadamob.service.IPictureGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/picture-galleries")
@CrossOrigin(origins = "http://localhost:4200")
public class PictureGalleryController {

    @Autowired
    private IPictureGalleryService pictureGalleryService;

    @Autowired
    private PictureGalleryMapper pictureGalleryMapper;

    @GetMapping
    public ResponseEntity<ApiSuccessResponseDto<List<PictureGalleryResponseDto>>> getAll() {
        List<PictureGallery> galleries = pictureGalleryService.findAll();
        List<PictureGalleryResponseDto> dtoList = galleries.stream()
                .map(pictureGalleryMapper::toResponseDto)
                .toList();
        return ResponseUtils.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<PictureGalleryResponseDto>> getById(@PathVariable Long id) {
        PictureGallery gallery = pictureGalleryService.findById(id);
        PictureGalleryResponseDto dto = pictureGalleryMapper.toResponseDto(gallery);
        return ResponseUtils.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<PictureGalleryResponseDto>> create(@Validated @RequestBody PictureGalleryRequestDto galleryDto) {
        PictureGallery gallery = pictureGalleryMapper.toEntity(galleryDto);
        PictureGallery created = pictureGalleryService.create(gallery);
        PictureGalleryResponseDto dto = pictureGalleryMapper.toResponseDto(created);
        return ResponseUtils.created(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<PictureGalleryResponseDto>> update(@PathVariable Long id, @Validated @RequestBody PictureGalleryRequestDto galleryDto) {
        pictureGalleryService.findById(id);
        PictureGallery gallery = pictureGalleryMapper.toEntity(galleryDto);
        gallery.setId(id);
        PictureGallery updated = pictureGalleryService.update(gallery);
        PictureGalleryResponseDto dto = pictureGalleryMapper.toResponseDto(updated);
        return ResponseUtils.updated(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Void>> delete(@PathVariable Long id) {
        pictureGalleryService.findById(id);
        pictureGalleryService.deleteById(id);
        return ResponseUtils.deleted();
    }
}
