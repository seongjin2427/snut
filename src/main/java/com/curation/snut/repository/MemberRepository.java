package com.curation.snut.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.curation.snut.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
