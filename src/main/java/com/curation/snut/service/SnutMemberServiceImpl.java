package com.curation.snut.service;

import com.curation.snut.dto.SnutMemberDTO;
import com.curation.snut.entity.SnutMember;
import com.curation.snut.repository.SnutMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class SnutMemberServiceImpl implements SnutMemberService{

    private final SnutMemberRepository snutMemberRepository;

    @Override
    public String register(SnutMemberDTO snutMemberDTO) {
        SnutMember snutMember = dtoToEntity(snutMemberDTO);
        log.info("register................................");
        snutMemberRepository.save(snutMember);
        return snutMember.getEmail();
    }

    @Override
    public SnutMemberDTO get(String email) {
        Optional<SnutMember> result = Optional.of(snutMemberRepository.getById(email));
        return result.isPresent() ? entitiesToDTO(result.get()) : null;
    }
}
