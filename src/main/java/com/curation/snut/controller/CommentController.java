package com.curation.snut.controller;

import java.util.Map;
import java.util.Optional;

import com.curation.snut.dto.CommentDTO;
import com.curation.snut.entity.CommuJoin;
import com.curation.snut.entity.Community;
import com.curation.snut.repository.CommuJoinRepository;
import com.curation.snut.repository.CommunityRepository;
import com.curation.snut.service.CommentService;
import com.curation.snut.service.CommunityService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommuJoinRepository commuJoinRepository;
    private final CommunityRepository communityRepository;

    @GetMapping(value = "/commentList")
    public ResponseEntity<Page<CommentDTO>> commentListTest(
            @PageableDefault(size = 2, sort = "cno", direction = Direction.ASC) final Pageable pageable,
            final Long no) {
        Page<CommentDTO> commentDTOList = commentService.commentList(pageable, no);
        return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/commentList")
    public ResponseEntity<?> commentWrite(CommentDTO commentDTO) {

        String writer = commentDTO.getWriter().getEmail();
        Long commuNo = commentDTO.getCommunityName().getNo();
        Optional<CommuJoin> findWriteAuthority = commuJoinRepository.findWriteAuthority(commuNo, writer);

        Optional<Community> findCreater = communityRepository.findByCreater(writer, commuNo);

        if (findWriteAuthority.isPresent()) {
            commentService.write(commentDTO);
            return new ResponseEntity<>("등록", HttpStatus.OK);
        } else if (findCreater.isPresent()) {
            commentService.write(commentDTO);
            return new ResponseEntity<>("등록", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("권한 없음", HttpStatus.OK);

        }
    }

    @PostMapping("/comment/delete")
    public ResponseEntity<?> commentDelete(@RequestBody Map body) {
        Long cno = Long.valueOf(body.get("cno").toString());
        String memberEmail = body.get("memberEmail").toString();
        String commnetEmail = body.get("commentEmail").toString();

        if (memberEmail == commnetEmail) {
            commentService.delete(cno);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("권한이 없습니다", HttpStatus.OK);
        }

    }
}
