package com.curation.snut.security.service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.curation.snut.entity.AuthorityRole;
import com.curation.snut.entity.Member;
import com.curation.snut.repository.MemberRepository;
import com.curation.snut.security.dto.AuthMemberDTO;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class CommonOAuth2UserDetailsService extends DefaultOAuth2UserService {

  private final MemberRepository repository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    log.info("OAuth2UserDetailsService..userRequest:" + userRequest);
    String clientName = userRequest.getClientRegistration().getClientName();
    log.info("clientName:" + clientName);
    log.info("getParameters:" + userRequest.getAdditionalParameters());

    OAuth2User oAuth2User = super.loadUser(userRequest);
    log.info("===========================");
    oAuth2User.getAttributes().forEach((k, v) -> {
      log.info(k + ":" + v);
    });
    String email = null;
    if (clientName.equals("Google"))
      email = oAuth2User.getAttribute("email");
    log.info("email:" + email);
    Member member = saveSocialMember(email);
    // return oAuth2User;
    AuthMemberDTO authMemberDTO = new AuthMemberDTO(
        member.getEmail(),
        member.getName(),
        member.getPw(),
        member.getMobile(),
        member.getBirth(),
        member.getGender(),
        member.getNickname(),
        member.isFromSocial(),
        member
            .getRoleSet().stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
            .collect(Collectors.toList()),
        oAuth2User.getAttributes());
    authMemberDTO.setName(member.getName());
    return authMemberDTO;
  }

  private Member saveSocialMember(String email) {
    Optional<Member> result = repository.findByEmail(email, true);
    if (result.isPresent())
      return result.get();

    // 없다면
    Member member = Member.builder()
        .email(email)
        .name(email)
        .pw(passwordEncoder.encode("1"))
        .fromSocial(true)
        .build();
    member.addMemberRole(AuthorityRole.GUEST);
    repository.save(member);
    return member;
  }
}
