package com.curation.snut.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.curation.snut.dto.CommunityDTO;
import com.curation.snut.entity.Community;
import com.curation.snut.repository.CommunityRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CommunityServiceImplTest {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    CommunityService communityService;

    @Test
    @Transactional
    void testCommunityListWithCnt() {
    }
}
