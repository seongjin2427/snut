package com.curation.snut.service;

import java.util.ArrayList;
import java.util.List;

import com.curation.snut.dto.CommentDTO;

import com.curation.snut.entity.CommunityComment;
import com.curation.snut.entity.Member;
import com.curation.snut.repository.CommentRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

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
    public List<CommentDTO> commentList(String email) {
        List<CommunityComment> communityComments = commentRepository.findAll();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (CommunityComment comment : communityComments) {
            // CommentDTO commentDTO = CommentDTO.builder()
            // .cno(comment.getCno())
            // .text(comment.getText())
            // .writer(Member.builder().email(email).build())
            // .announcement(comment.getAnnouncement())
            // .regDate(comment.getRegDate())
            // .modDate(comment.getModDate())
            // .build();

            CommentDTO commentDTO = CommentDTO.builder()
                    .cno(comment.getCno())
                    .text(comment.getText())
                    .writer(Member.builder().email(email).build())
                    .announcement(comment.getAnnouncement())
                    .regDate(comment.getRegDate())
                    .modDate(comment.getModDate())
                    .build();

            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }

}
