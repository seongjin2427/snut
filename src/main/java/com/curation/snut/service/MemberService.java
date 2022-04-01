package com.curation.snut.service;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.curation.snut.dto.MemberDTO;
import com.curation.snut.entity.AuthorityRole;
import com.curation.snut.entity.Member;

public interface MemberService {
  void updateMemberDTO(MemberDTO memberDTO);

  default Member dtoToEntity(MemberDTO memberDTO) {
    Member member = Member.builder()
        .email(memberDTO.getEmail())
        .pw(memberDTO.getPw())
        .name(memberDTO.getName())
        .nickname(memberDTO.getNickname())
        .mobile(memberDTO.getMobile())
        .birth(memberDTO.getBirth())
        .gender(memberDTO.getGender())
        .fromSocial(memberDTO.isFromSocial())
        // .roleSet(cMemberDTO.getAuthorities().stream().map(gran->{
        // System.out.println("gran>>"+gran);
        // return AuthorityRole.USER;
        // }).collect(Collectors.toSet()))
        .roleSet(memberDTO.getRoleSet().stream().map(
            new Function<String, AuthorityRole>() {
              @Override
              public AuthorityRole apply(String t) {
                if (t.equals("ROLE_USER"))
                  return AuthorityRole.GUEST;
                else if (t.equals("ROLE_MEMBER"))
                  return AuthorityRole.MEMBER;
                else if (t.equals("ROLE_ADMIN"))
                  return AuthorityRole.ADMIN;
                else
                  return AuthorityRole.GUEST;
              }
            }).collect(Collectors.toSet()))
        .build();

    return member;
  }

  default MemberDTO entityToDTO(Member member) {
    MemberDTO memberDTO = MemberDTO.builder()
        .email(member.getEmail())
        .name(member.getName())
        .mobile(member.getMobile())
        .fromSocial(member.isFromSocial())
        .roleSet(member.getRoleSet().stream().map(
            role -> new String("ROLE_" + role.name()))
            .collect(Collectors.toSet()))
        .regDate(member.getRegDate())
        .modDate(member.getModDate())
        .build();
    return memberDTO;
  }
}
