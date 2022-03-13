package com.curation.snut.dto;

import java.time.LocalDateTime;

import com.curation.snut.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private Long cno;
    private String text;
    private String announcement;
    private Member writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
