package com.curation.snut.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {
    private Long noteNo;
    private String noteTitle;
    private String email;
    private String noteText;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Long stickerNo;
}
