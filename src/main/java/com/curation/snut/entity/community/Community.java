package com.curation.snut.entity.community;

import javax.persistence.*;

import com.curation.snut.entity.BaseEntity;
import com.curation.snut.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Community extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String title;
    private String thumbnail;

    @Column(length = 200000)
    private String text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Member creater;
}
