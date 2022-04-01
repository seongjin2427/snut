package com.curation.snut.security.service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.curation.snut.entity.Member;
import com.curation.snut.repository.MemberRepository;
import com.curation.snut.security.dto.AuthMemberDTO;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CommonUserDetailsService implements UserDetailsService {

  private final MemberRepository repository;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    log.info("BiUserDetailsService loadUserByNname:" + name);
    Optional<Member> result = repository.findByEmail(name);
    if (!result.isPresent()) {
      throw new UsernameNotFoundException("Check Email or Social");
    }
    Member member = result.get();
    log.info("member: " + member);
    AuthMemberDTO authMemberDTO = new AuthMemberDTO(
        member.getEmail(),
        member.getPw(),
        member.getName(),
        member.getMobile(),
        member.getBirth(),
        member.getGender(),
        member.getNickname(),
        member.isFromSocial(),
        member.getRoleSet().stream().map(
            role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
            .collect(Collectors.toSet()),
        null);
    authMemberDTO.setName(member.getName());
    authMemberDTO.setFromSocial(member.isFromSocial());
    return authMemberDTO;
  }
}
