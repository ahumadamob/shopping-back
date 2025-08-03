package com.ahumadamob.mapper;

import com.ahumadamob.dto.PictureRequestDto;
import com.ahumadamob.dto.PictureResponseDto;
import com.ahumadamob.entity.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {

    public Picture toEntity(PictureRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Picture picture = new Picture();
        picture.setUrl(dto.getUrl());
        picture.setPath(dto.getPath());
        picture.setFileName(dto.getFileName());
        picture.setMimeType(dto.getMimeType());
        picture.setSize(dto.getSize());
        picture.setOrder(dto.getOrder());
        picture.setCover(dto.getCover());
        return picture;
    }

    public PictureResponseDto toResponseDto(Picture picture) {
        if (picture == null) {
            return null;
        }
        PictureResponseDto dto = new PictureResponseDto();
        dto.setId(picture.getId());
        dto.setUrl(picture.getUrl());
        dto.setPath(picture.getPath());
        dto.setFileName(picture.getFileName());
        dto.setMimeType(picture.getMimeType());
        dto.setSize(picture.getSize());
        dto.setOrder(picture.getOrder());
        dto.setCover(picture.getCover());
        dto.setCreatedDate(picture.getCreatedDate());
        return dto;
    }
}
