package com.curation.snut.repository;

import com.curation.snut.service.StoredDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoredDataRepositoryTests {

    @Autowired
    private StoredDataService storedDataService;

    @Test
    void storeCurationTest() {
        storedDataService.storeCuration(1L, "fo");

    }


}