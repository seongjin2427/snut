package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Curation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cuid;

    private long coid;
    private String title;
    private String text;
    private boolean publicPrivateBool;

    @ManyToOne(fetch = FetchType.LAZY)
    private SnutMember email;
}
