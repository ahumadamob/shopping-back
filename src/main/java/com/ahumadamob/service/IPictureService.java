package com.ahumadamob.service;

import com.ahumadamob.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPictureService {
    List<Picture> findAll();
    Picture findById(Long id);
    Picture create(Picture picture);
    Picture create(MultipartFile file, Integer order, Boolean cover);
    Picture update(Picture picture);
    void deleteById(Long id);
}
