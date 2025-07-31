package com.ahumadamob.repository;

import com.ahumadamob.entity.PictureGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureGalleryRepository extends JpaRepository<PictureGallery, Long> {
}
