package com.curation.snut.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
<<<<<<< HEAD:src/main/java/com/curation/snut/entity/Curation.java
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
=======
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.curation.snut.idclass.CommunityLikeId;
>>>>>>> ca64f923ad2d113526a840b7f662fa703d16aa2f:src/main/java/com/curation/snut/entity/CommunityLike.java

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
<<<<<<< HEAD:src/main/java/com/curation/snut/entity/Curation.java
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
=======
@ToString
@IdClass(CommunityLikeId.class)
public class CommunityLike {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Community community;
>>>>>>> ca64f923ad2d113526a840b7f662fa703d16aa2f:src/main/java/com/curation/snut/entity/CommunityLike.java

    // @OneToMany(mappedBy = "curation", cascade = CascadeType.ALL)
    // Set<CuLike> likes = new HashSet<>();
}
