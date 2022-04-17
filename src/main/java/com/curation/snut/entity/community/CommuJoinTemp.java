package com.curation.snut.entity.community;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.curation.snut.entity.Member;
import com.curation.snut.idclass.CommuJoinTempId;

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
@IdClass(CommuJoinTempId.class)
public class CommuJoinTemp {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member tMember;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Community tCommunity;
}
