package com.curation.snut.service;

import com.curation.snut.dto.CommuLikeDTO;
import com.curation.snut.entity.Community;
import com.curation.snut.entity.CommunityLike;
import com.curation.snut.entity.Member;

public interface CommuLikeService {

    void reg(CommuLikeDTO commuLikeDTO);

    default CommunityLike dtoToEntity(CommuLikeDTO dto) {
        Member member = Member.builder()
                .email(dto.getMember().getEmail())
                .build();
        Community community = Community.builder()
                .no(dto.getCommunity().getNo())
                .build();

        CommunityLike communityLike = CommunityLike.builder()
                .member(member)
                .community(community)
                .build();
        return communityLike;
    }

    default CommuLikeDTO entityToDTO(CommunityLike Like) {

        CommuLikeDTO dto = CommuLikeDTO.builder()
                .member(Like.getMember())
                .community(Like.getCommunity())
                .build();

        return dto;
    }
}
