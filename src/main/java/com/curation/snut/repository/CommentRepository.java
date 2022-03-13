package com.curation.snut.repository;

import com.curation.snut.entity.CommunityComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommunityComment, Long> {
}
