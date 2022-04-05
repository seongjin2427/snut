package com.curation.snut.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.curation.snut.idclass.CurationLikeId;

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
@IdClass(CurationLikeId.class)
public class CurationLike implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Curation curation;

}
