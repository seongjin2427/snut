package com.curation.snut.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.curation.snut.entity.Curation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CurationRepository extends JpaRepository<Curation, Long> {

    @Query("select c from Curation c order by curationNo")
    Page<Curation> list(Pageable pageable, Long curationNo);

    @Modifying
    @Transactional
    @Query("delete from Curation c where c.curationNo = :id")
    void deleteCuration(Long id);

    @Transactional
    @Query("select curationNo from Curation c where c.curationNo= :id and c.curationNo is null")
    Long searchCuration(Long id);

}