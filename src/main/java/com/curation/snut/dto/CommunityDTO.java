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
public class CommunityDTO {
    private Long no;
    private String title;
    private String thumbnail;
    private Member creater;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
