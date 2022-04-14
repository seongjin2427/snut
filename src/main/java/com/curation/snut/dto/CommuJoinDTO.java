package com.curation.snut.dto;

import com.curation.snut.entity.Community;
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
public class CommuJoinDTO {
    private Member member;
    private Community community;
}
