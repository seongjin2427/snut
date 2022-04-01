// package com.curation.snut.service;

// import com.curation.snut.entity.CuLikes;
// import com.curation.snut.entity.Culikes;
// import com.curation.snut.entity.Curation;
// import com.curation.snut.entity.Member;
// import com.curation.snut.repository.CuLikesRepository;
// import com.curation.snut.repository.CurationRepository;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import lombok.RequiredArgsConstructor;

// @Transactional
// @RequiredArgsConstructor
// @Service

// public class CuLikesService {
// private final CuLikesRepository culikesRepository;
// private final CurationRepository curationRepository;

// public boolean addCulikes(Member member, Long CurationNo) {
// Curation curation = curationRepository.findById(CurationNo).orElseThrow();
// // 중복좋아요 방지
// if (isNotAlreadylikes(member, curation)) {
// CuLikesRepository.save(new CuLikes(curation, member));
// return true;
// }
// return false;
// }

// // 사용자가 이미 좋아요 한 게시물인지 체크
// private boolean isNotAlreadylikes(Member member, Curation curation) {
// return culikesRepository.findByMemberAndCuration(member, curation).isEmpty();
// }
// }
