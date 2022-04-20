package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MemberCurationLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcuId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    private Curation curation;

    @Builder
    public void Likes(Curation curation, Member member) {
            this.curation = curation;
            this.member = member;
    }
}
