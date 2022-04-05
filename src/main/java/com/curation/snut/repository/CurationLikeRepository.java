package com.curation.snut.repository;

import com.curation.snut.entity.CurationLike;
import com.curation.snut.idclass.CurationLikeId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurationLikeRepository extends JpaRepository<CurationLike, CurationLikeId> {

}
