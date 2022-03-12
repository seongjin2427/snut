package com.curation.snut.repository;

import com.curation.snut.entity.Collection;
import com.curation.snut.entity.SnutMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class CollectionRepositoryTests {

    @Autowired
    private CollectionRepository collectionRepository;

    @Test
    public void insertCollectionDummies() {
        IntStream.rangeClosed(1, 200).forEach(i -> {

            int random = (int)Math.floor(Math.random() * 100) + 1;

            Collection collection = Collection.builder()
                    .title("Title......." + i)
                    .open(true)
                    .snutMember(SnutMember.builder().email("user" + random + "@naver.com").build())
                    .build();

            collectionRepository.save(collection);
        });
    }
}