package com.curation.snut.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.curation.snut.entity.Curation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CurationRepository extends JpaRepository<Curation, Long> {

    // 성진
    @Query("select co.curation from ColCuration co where co.snutCollection.collectionNo = :no order by co.curation.modDate asc")
    List findCurationsByCollectionNo(Long no);


    @Query("select distinct cu from Curation cu join cu.hashtag h where h like concat('%', :word, '%')")
    List findCurationByWord(@Param("word") String word);
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    @Query("select c from Curation c order by curationNo")
    Page<Curation> list(Pageable pageable, Long curationNo);

    @Modifying
    @Transactional
    @Query("delete from Curation c where c.curationNo = :id")
    void deleteCuration(Long id);

    // 쿼리수정
    // @Query("select c, curationNo from Curation c left outer join c.title
    // like%:searchTitle%")
    List<Object[]> findByCurationTitleContaining(String searchTitle);

    Object getCurationByCurationNo(@Param("curationNo") Long curationNo);
}