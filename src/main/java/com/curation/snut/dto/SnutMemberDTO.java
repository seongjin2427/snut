package com.curation.snut.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SnutMemberDTO {
    private String email;
    private String mobile;
    private String name;
    private String pw;
    private Boolean gender;
    private LocalDateTime birth;
    private String nickname;
    private String authId;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
