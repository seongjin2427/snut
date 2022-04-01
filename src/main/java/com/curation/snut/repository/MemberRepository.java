package com.curation.snut.repository;

import java.util.Optional;

import com.curation.snut.entity.Member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // EntityGraph일 경우
    // FETCH: entity graph에 명시한 attribute는 EAGER로 패치하고,
    // 나머지 attribute는 LAZY로 패치
    // LOAD: entity graph에 명시한 attribute는 EAGER로 패치하고,
    // 나머지 attribute는 entity에 명시한 fetch type이나
    // 디폴트 FetchType으로 패치
    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraphType.LOAD)
    @Query("select m from Member m where m.fromSocial=:social "
            + "and m.email=:email")
    Optional<Member> findByEmail(String email, boolean social);

    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraphType.LOAD)
    @Query("select m from Member m where m.email=:email")
    Optional<Member> findByEmail(String email);

}
