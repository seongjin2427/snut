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
                .email("456@456.456")
                .name("456")
                .pw("456")
                .mobile("456456")
                .birth("456")
                .gender("male")
                .nickname("Def")
                .build();
        memberRepository.save(member);
    }

    @Test
    public void insertMember2() {
        Member member = Member.builder()
                .email("123@123.123")
                .name("123")
                .pw("123")
                .mobile("123")
                .birth("123")
                .gender("female")
                .nickname("Abc")
                .build();
        memberRepository.save(member);
    }

}
