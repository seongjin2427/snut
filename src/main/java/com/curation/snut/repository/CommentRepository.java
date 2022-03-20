package com.curation.snut.repository;

import java.util.List;

import com.curation.snut.entity.Community;
import com.curation.snut.entity.CommunityComment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<CommunityComment, Long> {

    // 실험용
    @Query("select c from CommunityComment c where c.communityName.no = :no order by if(isnull(parentNo), cno, parentNo)")
    Page<CommunityComment> list2(Pageable pageable, Long no);

    @Query("select c from CommunityComment c order by if(isnull(parentNo), cno, parentNo)")
    Page<CommunityComment> list(Pageable pageable);

    @Modifying
    @Transactional
    @Query("delete from CommunityComment c where c.parentNo = :id")
    void deleteReply(Long id);

    @Query("select cno from CommunityComment c where c.cno= :id and c.parentNo is null")
    Long searchComment(Long id);
}
