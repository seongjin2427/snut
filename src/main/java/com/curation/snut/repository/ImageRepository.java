package com.curation.snut.repository;

import com.curation.snut.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long>{
    
}
