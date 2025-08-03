package com.ahumadamob.service;

import com.ahumadamob.entity.PictureGallery;

import java.util.List;

public interface IPictureGalleryService {
    List<PictureGallery> findAll();
    PictureGallery findById(Long id);
    PictureGallery create(String description, List<Long> pictureIds);
    PictureGallery update(PictureGallery gallery);
    void deleteById(Long id);
}
