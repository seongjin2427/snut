package com.curation.snut.dto;

import java.time.LocalDateTime;
import java.util.List;

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
    private String curationTitle;
    private String email;

    // private String email;

    private String curationText;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private boolean open;

}
