package com.curation.snut.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.curation.snut.entity.Member;
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

public class CurationDTO {
    private Long curationNo;

    private String email;
    private String nickname;

    private String curationTitle;
    private String curationText;
    private Set hashtag;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean open;
    // 검색용
    private String type;
    private String keyword;

}