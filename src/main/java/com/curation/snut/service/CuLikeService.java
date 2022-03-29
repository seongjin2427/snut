// package com.curation.snut.service;

// import com.curation.snut.entity.CuLike;
// import com.curation.snut.entity.Curation;
// import com.curation.snut.entity.Member;
// import com.curation.snut.repository.CuLikeRepository;
// import com.curation.snut.repository.CurationRepository;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import lombok.RequiredArgsConstructor;

// @Transactional
// @RequiredArgsConstructor
// @Service

// public class CuLikeService {
// private final CuLikeRepository cuLikeRepository;
// private final CurationRepository curationRepository;

// public boolean addCuLike(Member member, Long CurationNo) {
// Curation curation = curationRepository.findById(CurationNo).orElseThrow();
// // 중복좋아요 방지
// if (isNotAlreadyLike(member, curation)) {
// cuLikeRepository.save(new CuLike(curation, member));
// return true;
// }
// return false;
// }

// // 상ㅇ자가 이미 좋아요 한 게시물인지 체크
// private boolean isNotAlreadyLike(Member member, Curation curation) {
// return cuLikeRepository.findByMemberAndCuration(member, curation).isEmpty();
// }
// }
