package com.ahumadamob.controller;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.PictureRequestDto;
import com.ahumadamob.dto.PictureResponseDto;
import com.ahumadamob.common.ResponseUtils;
import com.ahumadamob.entity.Picture;
import com.ahumadamob.mapper.PictureMapper;
import com.ahumadamob.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pictures")
@CrossOrigin(origins = "http://localhost:4200")
public class PictureController {

    @Autowired
    private IPictureService pictureService;

    @Autowired
    private PictureMapper pictureMapper;

    @GetMapping
    public ResponseEntity<ApiSuccessResponseDto<List<PictureResponseDto>>> getAll() {
        List<Picture> pictures = pictureService.findAll();
        List<PictureResponseDto> dtoList = pictures.stream()
                .map(pictureMapper::toResponseDto)
                .toList();
        return ResponseUtils.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<PictureResponseDto>> getById(@PathVariable Long id) {
        Picture picture = pictureService.findById(id);
        PictureResponseDto dto = pictureMapper.toResponseDto(picture);
        return ResponseUtils.ok(dto);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiSuccessResponseDto<PictureResponseDto>> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "order", required = false) Integer order,
            @RequestParam(value = "cover", required = false) Boolean cover) {
        Picture created = pictureService.create(file, order, cover);
        PictureResponseDto dto = pictureMapper.toResponseDto(created);
        return ResponseUtils.created(dto);
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponseDto<PictureResponseDto>> create(@Validated @RequestBody PictureRequestDto pictureDto) {
        Picture picture = pictureMapper.toEntity(pictureDto);
        Picture created = pictureService.create(picture);
        PictureResponseDto dto = pictureMapper.toResponseDto(created);
        return ResponseUtils.created(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<PictureResponseDto>> update(@PathVariable Long id, @Validated @RequestBody PictureRequestDto pictureDto) {
        pictureService.findById(id); // verify existence
        Picture picture = pictureMapper.toEntity(pictureDto);
        picture.setId(id);
        Picture updated = pictureService.update(picture);
        PictureResponseDto dto = pictureMapper.toResponseDto(updated);
        return ResponseUtils.updated(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiSuccessResponseDto<Void>> delete(@PathVariable Long id) {
        pictureService.findById(id); // verify existence
        pictureService.deleteById(id);
        return ResponseUtils.deleted();
    }
}
