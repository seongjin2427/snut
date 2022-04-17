package com.curation.snut.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.curation.snut.idclass.CommuJoinId;

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
@IdClass(CommuJoinId.class)
public class CommuJoin {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member jMember;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Community jCommunity;

}
