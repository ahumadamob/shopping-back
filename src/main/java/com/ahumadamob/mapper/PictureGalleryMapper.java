package com.ahumadamob.mapper;

import com.ahumadamob.dto.PictureGalleryRequestDto;
import com.ahumadamob.dto.PictureGalleryResponseDto;
import com.ahumadamob.dto.PictureResponseDto;
import com.ahumadamob.entity.Picture;
import com.ahumadamob.entity.PictureGallery;
import com.ahumadamob.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PictureGalleryMapper {

    @Autowired
    private IPictureService pictureService;

    @Autowired
    private PictureMapper pictureMapper;

    public PictureGallery toEntity(PictureGalleryRequestDto dto) {
        if (dto == null) {
            return null;
        }
        PictureGallery gallery = new PictureGallery();
        gallery.setDescription(dto.getDescription());
        if (dto.getPictureIds() != null) {
            List<Picture> pictures = dto.getPictureIds().stream()
                    .map(pictureService::findById)
                    .toList();
            gallery.setPictures(pictures);
        }
        return gallery;
    }

    public PictureGalleryResponseDto toResponseDto(PictureGallery gallery) {
        if (gallery == null) {
            return null;
        }
        PictureGalleryResponseDto dto = new PictureGalleryResponseDto();
        dto.setId(gallery.getId());
        dto.setDescription(gallery.getDescription());
        List<PictureResponseDto> pictures = gallery.getPictures().stream()
                .map(pictureMapper::toResponseDto)
                .toList();
        dto.setPictures(pictures);
        return dto;
    }
}
