package com.ahumadamob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PictureResponseDto {
    private Long id;
    private String url;
    private String fileName;
    private String mimeType;
    private Long size;
    private Integer order;
    private Boolean cover;
    private LocalDateTime createdDate;
}
