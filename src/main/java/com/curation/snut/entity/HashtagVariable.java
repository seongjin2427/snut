package com.curation.snut.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class HashtagVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hashtag_hashtagId")
    @NonNull
    private Hashtag hashtag;

    @ManyToOne
    @JoinColumn(name = "curation_curationNo")
    @NonNull
    private Curation curation;

}
