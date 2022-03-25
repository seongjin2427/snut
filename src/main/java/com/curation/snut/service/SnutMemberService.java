package com.curation.snut.service;

import com.curation.snut.dto.SnutMemberDTO;
import com.curation.snut.entity.SnutMember;

import java.util.HashMap;
import java.util.Map;

public interface SnutMemberService {

    String register(SnutMemberDTO snutMemberDTO);

    SnutMemberDTO get(String email);

    default SnutMember dtoToEntity(SnutMemberDTO snutMemberDTO) {

        SnutMember snutMember = SnutMember.builder()
                .email(snutMemberDTO.getEmail())
                .mobile(snutMemberDTO.getMobile())
                .name(snutMemberDTO.getName())
                .pw(snutMemberDTO.getPw())
                .gender(snutMemberDTO.getGender())
                .birth(snutMemberDTO.getBirth())
                .nickname(snutMemberDTO.getNickname())
                .authId(snutMemberDTO.getAuthId())
                .build();

        return snutMember;
    }

    default SnutMemberDTO entitiesToDTO(SnutMember snutMember) {
        SnutMemberDTO snutMemberDTO = SnutMemberDTO.builder()
                .email(snutMember.getEmail())
                .mobile(snutMember.getMobile())
                .name(snutMember.getName())
                .pw(snutMember.getPw())
                .gender(snutMember.getGender())
                .birth(snutMember.getBirth())
                .nickname(snutMember.getNickname())
                .authId(snutMember.getAuthId())
                .regDate(snutMember.getRegDate())
                .modDate(snutMember.getModDate())
                .build();
        return snutMemberDTO;

    }
}
