package com.curation.snut.repository;

import com.curation.snut.entity.SnutMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class SnutMemberRepositoryTests {

    @Autowired
    private SnutMemberRepository snutMemberRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 50).forEach(i -> {
            SnutMember snutMemberMale = SnutMember.builder()
                    .email("user" + i + "@naver.com")
                    .name("user" + i)
                    .mobile("000-0000-0" + i)
                    .pw("1111")
                    .gender(true)
                    .birth(LocalDateTime.now())
                    .nickname("userNickName" + i)
                    .authId("1111")
                    .build();

            snutMemberRepository.save(snutMemberMale);
        });
        IntStream.rangeClosed(51, 100).forEach(j -> {
            SnutMember snutMemberFemale = SnutMember.builder()
                    .email("user" + j + "@naver.com")
                    .name("user" + j)
                    .mobile("000-0000-0" + j)
                    .pw("1111")
                    .gender(false)
                    .birth(LocalDateTime.now())
                    .nickname("userNickName" + j)
                    .authId("1112")
                    .build();

            snutMemberRepository.save(snutMemberFemale);
        });
    }

}