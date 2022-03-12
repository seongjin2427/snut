package com.curation.snut.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class SnutMember extends BaseEntity {

    @Id
    private String email;
    
    private String name;
    private String mobile;
    private String pw;
    private Boolean gender;
    private LocalDateTime birth;
    private String nickname;
    private String authId;

}
