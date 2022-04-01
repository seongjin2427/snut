// package com.curation.snut.repository;

// import java.util.Optional;

// import com.curation.snut.entity.CuLikes;
// import com.curation.snut.entity.Curation;
// import com.curation.snut.entity.Member;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.transaction.annotation.Transactional;

// @Transactional(readOnly = true)
// public interface CuLikesRepository extends JpaRepository<CuLikes,Long>{
// Optional<CuLikes> findByMemberAndCuration(Member member,Curation curation);

// }
