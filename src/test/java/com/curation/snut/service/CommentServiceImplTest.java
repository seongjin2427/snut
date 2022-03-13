package com.curation.snut.service;

import com.curation.snut.dto.CommentDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Test
    void testWrite() {
        CommentDTO commentDTO = CommentDTO.builder()
                .text("test text")
                .writer("123@123.123")
                .build();
        commentService.write(commentDTO);
    }

}
