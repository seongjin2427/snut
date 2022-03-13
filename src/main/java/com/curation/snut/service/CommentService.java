package com.curation.snut.service;

import java.util.List;

import com.curation.snut.dto.CommentDTO;
import com.curation.snut.entity.CommunityComment;
import com.curation.snut.entity.Member;

public interface CommentService {

    void write(CommentDTO commentDTO);

    public List<CommentDTO> commentList(String email); // 리스트

    default CommunityComment dtoToEntity(CommentDTO dto) {
        // Member member = Member.builder()
        // .email(dto.getWriter())
        // .build();

        Member member = Member.builder()
                .email(dto.getWriter().getEmail())
                .build();

        CommunityComment comment = CommunityComment.builder()
                .cno(dto.getCno())
                .text(dto.getText())
                .announcement(dto.getAnnouncement())
                .writer(member)
                .build();
        return comment;
    }

    default CommentDTO entityToDTO(CommunityComment comment, String email) {
        CommentDTO commentDTO = CommentDTO.builder()
                .cno(comment.getCno())
                .text(comment.getText())
                .announcement(comment.getAnnouncement())
                .writer(Member.builder().email(email).build())
                .regDate(comment.getRegDate())
                .modDate(comment.getModDate())
                .build();
        return commentDTO;
    }
}
