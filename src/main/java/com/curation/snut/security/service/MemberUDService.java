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

@Service
@RequiredArgsConstructor
public class MemberUDService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> result = memberRepository.findyByEmail(username);

        if (result.isPresent()) {
            throw new UsernameNotFoundException("check Email");
        }

        Member member = result.get();

        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getEmail(), member.getName(),
                member.getPw(), member.getMobile(), member.getBirth(), member.getGender(), member.getNickname(),
                member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toSet()));

        authMemberDTO.setEmail(member.getEmail());
        return authMemberDTO;
    }
}
