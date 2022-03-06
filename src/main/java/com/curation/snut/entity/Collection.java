package com.curation.snut.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

public class Collection extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ColNo;
    
    private String ColTitle;
    private boolean open;
    //public 이나 prviate 쓸려고 했는데 못쓰는거라 open이라고 씀
    @ManyToOne(fetch = FetchType.LAZY)
    private Folder folder;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
