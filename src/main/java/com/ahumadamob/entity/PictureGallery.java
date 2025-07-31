package com.ahumadamob.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "picture_galleries")
@Getter
@Setter
@NoArgsConstructor
public class PictureGallery extends BaseEntity {

    @Column(name = "description", nullable = false, length = 255)
    @NotBlank
    @Size(max = 255)
    private String description;

    @ManyToMany
    @JoinTable(name = "picture_gallery_pictures",
            joinColumns = @JoinColumn(name = "gallery_id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id"))
    private List<Picture> pictures = new ArrayList<>();
}
