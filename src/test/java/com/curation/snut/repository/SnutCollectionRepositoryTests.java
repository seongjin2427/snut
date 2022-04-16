package com.curation.snut.repository;

import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Hashtag;
import com.curation.snut.entity.Member;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.service.SnutCollectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SnutCollectionRepositoryTests {

    @Autowired
    private SnutCollectionService snutCollectionService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CurationRepository curationRepository;
    @Autowired
    private HashtagRepository hashtagRepository;

    @Transactional
    @Commit
    @Test
    void collectionRegisterTest() {
        int num = 1;

        Set<Hashtag> tagSet = new HashSet<>();
        List<Curation> cuList = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            Hashtag hashtag = Hashtag.builder().tag("sampleTag" + i).build();
            hashtagRepository.save(hashtag);
            tagSet.add(hashtag);

            Optional<Curation> cu = curationRepository.findById((long)332 + i);
            cuList.add(cu.get());
        }

        SnutCollectionDTO colDTO = SnutCollectionDTO.builder()
                .collectionTitle("Collection Title" + num)
                .collectionText("Collection Text" + num)
                .hashtag(tagSet)
                .email("email10@gmail.com")
                .curations(cuList)
                .build();

        Long result = snutCollectionService.snutCollectionRegister(colDTO);

        System.out.println(result);
    }
}