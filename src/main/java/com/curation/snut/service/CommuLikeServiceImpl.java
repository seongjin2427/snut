package com.curation.snut.service;

import com.curation.snut.dto.CommuLikeDTO;
import com.curation.snut.entity.CommunityLike;
import com.curation.snut.repository.CommuLikeRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommuLikeServiceImpl implements CommuLikeService {
    private final CommuLikeRepository commuLikeRepository;

    @Override
    public void reg(CommuLikeDTO commuLikeDTO) {
        CommunityLike communityLike = dtoToEntity(commuLikeDTO);
        commuLikeRepository.save(communityLike);
    }

}
