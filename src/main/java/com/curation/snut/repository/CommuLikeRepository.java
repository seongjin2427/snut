package com.curation.snut.repository;

import com.curation.snut.entity.CommunityLike;
import com.curation.snut.idclass.CommunityLikeId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuLikeRepository extends JpaRepository<CommunityLike, CommunityLikeId> {

}
