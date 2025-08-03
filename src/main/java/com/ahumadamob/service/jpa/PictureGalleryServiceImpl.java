package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.PictureGallery;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.PictureGalleryRepository;
import com.ahumadamob.service.IPictureGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureGalleryServiceImpl implements IPictureGalleryService {

    @Autowired
    private PictureGalleryRepository pictureGalleryRepository;

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
    public PictureGallery create(PictureGallery gallery) {
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
