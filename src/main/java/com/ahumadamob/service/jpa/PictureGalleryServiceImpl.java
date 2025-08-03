package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.PictureGallery;
import com.ahumadamob.entity.Picture;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.PictureGalleryRepository;
import com.ahumadamob.service.IPictureGalleryService;
import com.ahumadamob.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureGalleryServiceImpl implements IPictureGalleryService {

    @Autowired
    private PictureGalleryRepository pictureGalleryRepository;

    @Autowired
    private IPictureService pictureService;

    @Override
    public List<PictureGallery> findAll() {
        return pictureGalleryRepository.findAll();
    }

    @Override
    public PictureGallery findById(Long id) {
        return pictureGalleryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PictureGallery", id));
    }

    @Override
    public PictureGallery create(String description, List<Long> pictureIds) {
        PictureGallery gallery = new PictureGallery();
        gallery.setDescription(description);
        if (pictureIds != null) {
            List<Picture> pictures = pictureIds.stream()
                    .map(pictureService::findById)
                    .toList();
            gallery.setPictures(pictures);
        }
        return pictureGalleryRepository.save(gallery);
    }

    @Override
    public PictureGallery update(PictureGallery gallery) {
        return pictureGalleryRepository.save(gallery);
    }

    @Override
    public void deleteById(Long id) {
        pictureGalleryRepository.deleteById(id);
    }
}
