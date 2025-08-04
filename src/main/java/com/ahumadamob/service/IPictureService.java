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
    /**
     * Updates an existing {@link Picture} replacing its file and optionally
     * modifying its order or cover flag.
     *
     * @param id    identifier of the picture to update
     * @param file  new binary content
     * @param order optional order value
     * @param cover optional cover flag
     * @return the persisted picture with updated information
     */
    Picture update(Long id, MultipartFile file, Integer order, Boolean cover);
    void deleteById(Long id);
}
