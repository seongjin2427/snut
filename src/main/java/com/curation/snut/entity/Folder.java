package com.curation.snut.entity;

import javax.persistence.Entity;
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

public class Folder {
    @Id
    private Long fno;
    
    private String folderName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
