package com.curation.snut.repository;

import java.util.List;

import com.curation.snut.entity.Community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommunityRepository extends JpaRepository<Community, Long> {
    @Query("select c, count(cc.communityName.no) from Community c left outer join CommunityComment cc on c.no = cc.communityName.no where c.title like %:searchTitle% group by c.no")
    List<Object[]> findByTitleContaining(String searchTitle);

    @Query("select c, count(cc.communityName.no) from Community c left outer join CommunityComment cc on c.no = cc.communityName.no group by c.no")
    List<Object[]> countList();
}
