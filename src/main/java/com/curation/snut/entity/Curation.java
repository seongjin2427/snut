package com.curation.snut.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@ToString(exclude = "writer")
public class Curation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curationNo;

    private String curationTitle;
    private String curationText;
    private boolean open;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member writer;

    // @OneToMany(mappedBy = "curation", cascade = CascadeType.ALL)
    // Set<CuLike> likes = new HashSet<>();
}
