package com.curation.snut.controller;

import com.curation.snut.dto.CommentDTO;
import com.curation.snut.entity.Community;
import com.curation.snut.service.CommentService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
// import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

// @RestController
// @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping
@Log4j2
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 실험용
    @GetMapping("/comment2")
    public String comment2(Model model,
            @PageableDefault(page = 0, size = 2, sort = "cno", direction = Direction.ASC) Pageable pageable,
            Long no) {
        log.info("comment2......");
        Page<CommentDTO> commentDTOList = commentService.commentList2(pageable, no);
        model.addAttribute("commentList", commentDTOList);

        int nowPage = pageable.getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, commentDTOList.getTotalPages());
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "comment2.html";
    }

    @GetMapping("/comment")
    public String comment(Model model,
            @PageableDefault(page = 0, size = 10, sort = "cno", direction = Direction.ASC) Pageable pageable) {
        log.info("comment......");
        Page<CommentDTO> commentDTOList = commentService.commentList(pageable);
        model.addAttribute("commentList", commentDTOList);

        int nowPage = pageable.getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, commentDTOList.getTotalPages());
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "comment.html";
    }

    @PostMapping("/comment")
    public String commentWrite(CommentDTO commentDTO) {
        log.info("writed......." + commentDTO);
        commentService.write(commentDTO);
        return "redirect:/comment";
    }

    @GetMapping("/comment/delete")
    public String delete(Long id) {
        commentService.delete(id);
        return "redirect:/comment";
    }
}
