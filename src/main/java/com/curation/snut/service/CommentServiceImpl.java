package com.curation.snut.service;

import java.util.List;
import java.util.stream.Collectors;

import com.curation.snut.dto.CommentDTO;
import com.curation.snut.entity.Community;
import com.curation.snut.entity.CommunityComment;
import com.curation.snut.repository.CommentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void write(CommentDTO commentDTO) {
        CommunityComment communityComment = dtoToEntity(commentDTO);
        commentRepository.save(communityComment);
    }

    @Override
    public Page<CommentDTO> commentList(Pageable pageable, Long no) {
        Page<CommunityComment> communityComments = commentRepository.list(pageable, no);
        List<CommentDTO> commentDTOList = communityComments.stream()
                .map(comment -> entityToDTO(comment)).collect(Collectors.toList());
        return new PageImpl<>(commentDTOList, pageable, communityComments.getTotalElements());

    }

    @Transactional
    @Override
    public void delete(Long id) {
        Long CommentLists = commentRepository.searchComment(id);
        if (CommentLists != null) {
            commentRepository.deleteById(id);
            commentRepository.deleteReply(id);
        } else {
            commentRepository.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void deleteAllCommunutyComment(Long no) {
        commentRepository.deleteAllCommunutyComment(no);
    }

    // 실험용
    @Override
    public Page<CommentDTO> commentList2(Pageable pageable, Long no) {
        Page<CommunityComment> communityComments = commentRepository.list2(pageable, no);
        List<CommentDTO> commentDTOList = communityComments.stream()
                .map(comment -> entityToDTO(comment)).collect(Collectors.toList());
        return new PageImpl<>(commentDTOList, pageable, communityComments.getTotalElements());

    }

}
