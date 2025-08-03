package com.ahumadamob.service;

import com.ahumadamob.entity.PictureGallery;

import java.util.List;

public interface IPictureGalleryService {
    List<PictureGallery> findAll();
    PictureGallery findById(Long id);
    PictureGallery create(PictureGallery gallery);
    PictureGallery update(PictureGallery gallery);
    void deleteById(Long id);
}
