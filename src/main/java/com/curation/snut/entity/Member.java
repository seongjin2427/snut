package com.curation.snut.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Member extends BaseEntity implements Serializable {
    @Id
    private String email;

    private String name;
    private String pw;
    private String mobile;
    private String birth;
    private String gender;
    private String nickname;
    private boolean fromSocial;
    // private String AuthId;

    // jpa에서 연결되는 객체가 collection일 경우 사용
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<AuthorityRole> roleSet = new HashSet<>();

    public void addMemberRole(AuthorityRole authorityRole) {
        roleSet.add(authorityRole);
    }
}
