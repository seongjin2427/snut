package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> hashtag = new HashSet<>();


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "collection_cu_no")
//    private Set<SnutCollection> snutCollection = new LinkedHashSet<>();

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "curation")
    // private List<HashtagVariable> hashtag;

    public void changeCurationTitle(String curationTitle) {
        this.curationTitle = curationTitle;
    }

    public void changeCurationText(String curationText) {
        this.curationText = curationText;
    }
}