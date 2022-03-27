package com.curation.snut.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//image보다 좋아요나 컬렉션 우선으로.
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Image{
    @Id
    private Long ino;

    private String image;

    // @ManyToOne(fetch = FetchType.LAZY)
    // private Curation curation;
}