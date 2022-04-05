package com.curation.snut.service;

import com.curation.snut.dto.CurationLikeDTO;
import com.curation.snut.entity.CurationLike;
import com.curation.snut.repository.CurationLikeRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurationLikeServiceImpl implements CurationLikeService {
    private final CurationLikeRepository curationLikeRepository;

    @Override
    public void reg(CurationLikeDTO curationLikeDTO) {
        CurationLike curationLike = dtoToEntity(curationLikeDTO);
        curationLikeRepository.save(curationLike);
    }
}
