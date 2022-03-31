package com.curation.snut.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;
import com.curation.snut.service.CurationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class CurationRepositorytest {

    @Autowired
    CurationRepository curationRepository;

    @Autowired
    CurationService curationService;

    @Test
    public void insertCuration() {
        Curation curation = Curation.builder()
                .curationTitle("place")
                .curationText("place abcd")
                .writer(Member.builder().email("r1").build())
                .build();
        curationRepository.save(curation);
    }

    @Test
    public void insertCuration2() {
        Curation curation = Curation.builder()
                .curationTitle("place2")
                .build();
        curationRepository.save(curation);
    }

}
