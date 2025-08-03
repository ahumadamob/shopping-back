package com.ahumadamob.service;

import com.ahumadamob.entity.Picture;

import java.util.List;

public interface IPictureService {
    List<Picture> findAll();
    Picture findById(Long id);
    Picture create(Picture picture);
    Picture update(Picture picture);
    void deleteById(Long id);
}
