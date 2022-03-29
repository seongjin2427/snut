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
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CurationDTO {
    private Long curationNo;

    // private String email;

    private String curationTitle;
    private String curationText;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean open;
    private String email;

}
