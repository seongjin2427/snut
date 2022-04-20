package com.curation.snut.repository;

import com.curation.snut.entity.StoredData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredDataRepository extends JpaRepository<StoredData, Long> {
}
