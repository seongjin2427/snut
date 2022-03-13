package com.curation.snut.repository;

import com.curation.snut.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember() {
        Member member = Member.builder()
                .email("123@123.123")
                .name("123")
                .pw("123")
                .mobile("123123")
                .birth("123")
                .gender("male")
                .nickname("nickname")
                .build();
        memberRepository.save(member);
    }

}
