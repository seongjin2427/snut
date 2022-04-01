package com.curation.snut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hashtag extends BaseEntity {
    // BaseEntity상속받은이유= 실시간인기태그 기능도 구현할수도
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hashtagId;

    @Column(nullable = false)
    private String tagName;

}
// 그냥 검색하는거랑
// 해시태그 눌러서 검색하기 구현(search가 먼저 구현되어야함.)
// #뒤에 자동으로 태그로 구분하기랑 ','으로 구분하기
//
//
//
//