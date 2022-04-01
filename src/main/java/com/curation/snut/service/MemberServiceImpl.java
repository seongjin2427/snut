package com.curation.snut.service;

import com.curation.snut.dto.MemberDTO;
import com.curation.snut.entity.Member;
import com.curation.snut.repository.MemberRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  private final MemberRepository repository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void updateMemberDTO(MemberDTO memberDTO) {
    log.info("updateMemberDTO..MemberDTO:" + memberDTO);
    memberDTO.setPw(passwordEncoder.encode(memberDTO.getPw()));
    Member member = dtoToEntity(memberDTO);
    repository.save(member);
    log.info("cMember>>" + member);
  }

}
