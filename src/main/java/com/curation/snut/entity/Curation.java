package com.curation.snut.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "curation")
    // private List<HashtagVariable> hashtag;

    public void changeCurationTitle(String curationTitle) {
        this.curationTitle = curationTitle;
    }

    public void changeCurationText(String curationText) {
        this.curationText = curationText;
    }
}
