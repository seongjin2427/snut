package com.curation.snut.repository;

import com.curation.snut.entity.SnutCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SnutCollectionRepository extends JpaRepository<SnutCollection, Long> {

    @Query("select distinct sc from SnutCollection sc join sc.hashtag h where h like concat('%', :word, '%')")
    List findCurationByWord(@Param("word") String word);
}
