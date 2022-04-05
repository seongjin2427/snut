package com.curation.snut.dto;

import com.curation.snut.entity.Curation;
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

public class CurationLikeDTO {
    private Member member;
    private Curation curation;
}
