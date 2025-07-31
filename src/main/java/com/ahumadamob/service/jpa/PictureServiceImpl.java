package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.Picture;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.PictureRepository;
import com.ahumadamob.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Long id) {
        return pictureRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Picture", id));
    }

    @Override
    public Picture create(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public Picture update(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public void deleteById(Long id) {
        pictureRepository.deleteById(id);
    }
}
