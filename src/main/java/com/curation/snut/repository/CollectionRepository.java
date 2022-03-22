package com.curation.snut.repository;

import com.curation.snut.entity.Collection;
import com.curation.snut.entity.SnutMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

    List<Collection> findBySnutMember(SnutMember snutMember);

    List<Collection> findByTitleContains(String title);
}
