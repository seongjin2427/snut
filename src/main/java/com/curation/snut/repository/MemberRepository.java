package com.curation.snut.repository;

import java.util.Optional;

import com.curation.snut.entity.Member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {
    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.email =:email")
    Optional<Member> findyByEmail(String email);

}
