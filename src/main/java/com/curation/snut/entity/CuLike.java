// package com.curation.snut.entity;

// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @NoArgsConstructor
// @Getter
// @Setter
// @AllArgsConstructor
// @Table(name = "likes")
// @Entity

// public class CuLike {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @ManyToOne(fetch = FetchType.LAZY)
// private Curation curation;

// @ManyToOne(fetch = FetchType.LAZY)
// private Member member;

// public CuLike(Curation curation, Member member) {
// this.curation = curation;
// this.member = member;
// }
// }
