package com.ahumadamob.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PictureRequestDto {

    @NotBlank
    @URL
    private String url;

    @NotBlank
    private String path;

    @NotBlank
    @Size(max = 255)
    private String fileName;

    @NotBlank
    @Pattern(regexp = "^[\\w.+-]+/[\\w.+-]+$", message = "Formato MIME invalido")
    private String mimeType;

    @NotNull
    @Min(1)
    @Max(5 * 1024 * 1024)
    private Long size;

    @Min(0)
    private Integer order;

    @NotNull
    private Boolean cover = false;
}
