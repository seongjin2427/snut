package com.curation.snut.repository;

import com.curation.snut.entity.CurationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurationImageRepository extends JpaRepository<CurationImage, Long> {
}
