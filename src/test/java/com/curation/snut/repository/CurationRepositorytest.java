package com.curation.snut.repository;

import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CurationRepositorytest {

    @Autowired
    CurationRepository curationRepository;

    @Test
    public void insertCuration() {
        Curation curation = Curation.builder()
                .curationTitle("place")
                .curationText("place abcd")
                .writer(Member.builder().email("r1").build())
                // .creater(Member.builder().email("123@123.123").build())
                .build();
        curationRepository.save(curation);
    }

    @Test
    public void insertCuration2() {
        Curation curation = Curation.builder()
                .curationTitle("place2")
                // .creater(Member.builder().email("456@456.456").build())
                .build();
        curationRepository.save(curation);
    }

}
