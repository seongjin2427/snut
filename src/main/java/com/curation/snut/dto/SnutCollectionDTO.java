package com.curation.snut.dto;

import com.curation.snut.entity.Member;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SnutCollectionDTO {

    private Long collectionNo;
    private String collectionTitle;
    private String collectionText;

    private Set hashtag;

    private String email;
    private String nickname;
}
