package com.ahumadamob.service.jpa;

import com.ahumadamob.entity.Picture;
import com.ahumadamob.exception.EntityNotFoundException;
import com.ahumadamob.repository.PictureRepository;
import com.ahumadamob.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Value("${uploads.dir}")
    private String uploadDir;

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
    public Picture create(MultipartFile file, Integer order, Boolean cover) {
        Picture picture = storeFile(file);
        picture.setOrder(order);
        picture.setCover(cover != null ? cover : false);
        return pictureRepository.save(picture);
    }

    @Override
    public Picture update(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public Picture update(Long id, MultipartFile file, Integer order, Boolean cover) {
        Picture existing = findById(id);

        // Remove previous file if it exists
        if (existing.getPath() != null) {
            try {
                Files.deleteIfExists(Paths.get(existing.getPath()));
            } catch (IOException e) {
                throw new RuntimeException("Failed to delete old file", e);
            }
        }

        Picture fileData = storeFile(file);
        existing.setUrl(fileData.getUrl());
        existing.setPath(fileData.getPath());
        existing.setFileName(fileData.getFileName());
        existing.setMimeType(fileData.getMimeType());
        existing.setSize(fileData.getSize());
        if (order != null) {
            existing.setOrder(order);
        }
        if (cover != null) {
            existing.setCover(cover);
        }

        return pictureRepository.save(existing);
    }

    private Picture storeFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        String contentType = file.getContentType();

        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        }

        String uniqueName = UUID.randomUUID().toString() + extension;

        Path filePath;
        try {
            Path directory = Paths.get(uploadDir);
            Files.createDirectories(directory);
            filePath = directory.resolve(uniqueName);
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }

        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/" + uploadDir + "/")
                .path(uniqueName)
                .toUriString();

        Picture picture = new Picture();
        picture.setUrl(url);
        picture.setPath(filePath.toString());
        picture.setFileName(uniqueName);
        picture.setMimeType(contentType);
        picture.setSize(size);
        return picture;
    }

    @Override
    public void deleteById(Long id) {
        pictureRepository.deleteById(id);
    }
}
