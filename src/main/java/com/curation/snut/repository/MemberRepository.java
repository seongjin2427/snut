package com.curation.snut.repository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import com.curation.snut.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
=======

import java.util.Optional;

import com.curation.snut.entity.Member;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    @EntityGraph(attributePaths = { "roleSet" }, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Member> findByEmail(String email);

>>>>>>> ca64f923ad2d113526a840b7f662fa703d16aa2f
}
