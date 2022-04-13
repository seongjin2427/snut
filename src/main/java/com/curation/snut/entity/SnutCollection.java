package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SnutCollection extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collectionNo;

    private String collectionTitle;
    private String collectionText;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> hashtag = new HashSet<>();

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "curation_col_no")
//    private Set<Curation> curation = new LinkedHashSet<>();

}
