package com.curation.snut.repository;

import com.curation.snut.entity.ColCuration;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.security.role.MemberRole;
import com.curation.snut.service.CurationService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
class CurationRepositoryTests {

    @Autowired
    private CurationRepository curationRepository;
    @Autowired
    private SnutCollectionRepository collectionRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ColCurationRepository colCurationRepository;

    @Autowired
    private SnutCollectionRepository snutCollectionRepository;

    @Autowired
    private CurationService curationService;

    @Test
    void makeDummies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                    .email("email" + i + "@gmail.com")
                    .name("name..." + i)
                    .pw("1")
                    .nickName("nickName.." + i)
                    .gender("male")
                    .birth("1995-02-02")
                    .mobile("010-1234-5678")
                    .build();
            member.addMemberRole(MemberRole.USER);

            memberRepository.save(member);

        });

    }

    @Test
    void makeCurationDummies() {

        IntStream.rangeClosed(1, 300).forEach(i -> {

            long random5 = (long) (Math.floor(Math.random() * 11)+1);
            long random1 = (long) (Math.floor(Math.random() * 10)+1);
            long random2 = (long) (Math.floor(Math.random() * 10)+1);
            long random3 = (long) (Math.floor(Math.random() * 11)+1);

            System.out.println("random5 >>> "+random5);

            Set setString = new HashSet();
            setString.add("hash"+random1);
            setString.add("hash"+random2);
            setString.add("hash"+random3);
            Curation curation = Curation.builder()
                    .curationTitle("Curation Title...." + i)
                    .curationText("Curation Text....." + i)
                    .writer(Member.builder().email("email" + random5 + "@gmail.com").build())
                    .hashtag(setString)
                    .open(true)
                    .build();

            curationRepository.save(curation);

        });
    }

    @Test
    void findHashtagTest() {

        Set a = new HashSet<>();
        a.add("hash1");
//        List<Curation> list = curationRepository.findCurationByWord(a);

//        System.out.println(list.size());
//        Curation bb = list.get(30);
//        System.out.println(bb.getCurationText());
    }

    @Test
    void makeCollectionDummies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            long random1 = (long) (Math.floor(Math.random() * 100) + 1);

            long random2 = (long) (Math.floor(Math.random() * 100)+1);
            long random3 = (long) (Math.floor(Math.random() * 100)+1);
            long random4 = (long) (Math.floor(Math.random() * 100)+1);

            Set setString = new HashSet();
            setString.add("hash"+random2);
            setString.add("hash"+random3);
            setString.add("hash"+random4);
                SnutCollection collection = SnutCollection.builder()
                        .collectionTitle("Collection Title...." + i)
                        .collectionText("Collection Text..." + i)
                        .writer(Member.builder().email("email" + random1 + "@gmail.com").build())
                        .hashtag(setString)
                        .build();

                collectionRepository.save(collection);
        });
    }

    @Test
    void NvsNDummiesTest() {
        IntStream.rangeClosed(1, 300).forEach(i -> {

            Long collectionNo = (long)(Math.random()*100) + 1;

            Long mid = (long)(Math.random()*300) + 1;

            ColCuration colCuration = ColCuration.builder()
                    .snutCollection(SnutCollection.builder().collectionNo(collectionNo).build())
                    .curation(Curation.builder().curationNo(mid).build())
                    .build();

            colCurationRepository.save(colCuration);

        });
    }

    @Test
    void getCollectionTest() {

        List list = curationRepository.findCurationsByCollectionNo(1L);

        System.out.println(list.size());
        for(Object a : list) {
            Curation l = (Curation) a;
            System.out.println(l.getCurationTitle());
            System.out.println(l.getWriter().getEmail());
        }
    }

    @Test
    void curationTest() {

//        Set<String> a = new HashSet<>();
//        a.add("hash1");
        List list = curationRepository.findCurationByWord("ash2");

        System.out.println(list.size());
        int bb = 0;
        for(Object a : list) {
            Curation b = (Curation) a;
            System.out.println(b.getCurationNo());
            System.out.println(b.getHashtag());
            bb++;
        }
        System.out.println("bb >> " + bb);

    }

    @Test
    void collectionTest() {
        List list = snutCollectionRepository.findCurationByWord("ash2");

        System.out.println(list.size());
        int bb = 0;
        for(Object a : list) {
            SnutCollection b = (SnutCollection) a;
            System.out.println(b.getCollectionNo());
            System.out.println(b.getHashtag());
            bb++;
        }
        System.out.println("bb >> " + bb);
    }

}