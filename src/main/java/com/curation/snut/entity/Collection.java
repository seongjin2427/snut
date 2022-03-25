package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "snutMember")
public class Collection extends BaseEntity {

    @Id
    @GeneratedValue
    private Long colId;

    private String title;
    private Boolean open;

    @ManyToOne(fetch = FetchType.LAZY)
    private SnutMember snutMember;
}
