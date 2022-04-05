package com.curation.snut.service;

import com.curation.snut.dto.CurationLikeDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.CurationLike;
import com.curation.snut.entity.Member;

public interface CurationLikeService {
        void reg(CurationLikeDTO dto);

        default CurationLike dtoToEntity(CurationLikeDTO dto) {
                Member member = Member.builder()
                                .email(dto.getMember().getEmail())
                                .build();
                Curation curation = Curation.builder()
                                .curationNo(dto.getCuration().getCurationNo())
                                .build();
                CurationLike curationLike = CurationLike.builder()
                                .member(member)
                                .curation(curation).build();
                return curationLike;
        }

        default CurationLikeDTO entityToDTO(CurationLike like) {
                CurationLikeDTO dto = CurationLikeDTO.builder()
                                .member(like.getMember())
                                .curation(like.getCuration())
                                .build();

                return dto;
        }
}
