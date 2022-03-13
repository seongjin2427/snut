package com.curation.snut.controller;

import java.util.List;

import com.curation.snut.dto.CommentDTO;
import com.curation.snut.service.CommentService;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    public String comment(Model model) {
        log.info("comment......");
        List<CommentDTO> commentDTOList = commentService.commentList("123@123.123");
        model.addAttribute("commentList", commentDTOList);
        return "comment.html";
    }

    @PostMapping("/comment")
    public String commentWrite(CommentDTO commentDTO) {
        log.info("writed......." + commentDTO);
        commentService.write(commentDTO);
        return "redirect:/comment";
    }
}
