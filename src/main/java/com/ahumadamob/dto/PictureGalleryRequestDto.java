package com.ahumadamob.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PictureGalleryRequestDto {

    @NotBlank
    @Size(max = 255)
    private String description;

    private List<Long> pictureIds;
}
