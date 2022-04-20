package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MemberCollectionLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcolId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    private SnutCollection snutCollection;

    @Builder
    public void Likes(SnutCollection snutCollection, Member member) {
        this.snutCollection = snutCollection;
        this.member = member;
    }
}