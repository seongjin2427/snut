package com.curation.snut.security.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
public class AuthMemberDTO extends User implements OAuth2User {
  private String email;
  private String name;
  private String pw;
  private String nickname;
  private String gender;
  private String mobile;
  private String birth;
  private boolean fromSocial;
  private Map<String, Object> attr;// Social에서 오는 OAuth정보

  // DB로부터 사용자를 초기화하는 생성자1
  public AuthMemberDTO(
      String email, String name, String pw,
      String nickname, String gender,
      String birth, String mobile,
      boolean fromSocial,
      Collection<? extends GrantedAuthority> authorities) {
    super(name, pw, authorities);
    this.email = email;
    this.name = name;
    this.pw = pw;
    this.nickname = nickname;
    this.gender = gender;
    this.mobile = mobile;
    this.birth = birth;
    this.fromSocial = fromSocial;
    log.info("ClubAuthMemberDTO 생성자 실행");
  }

  // OAuth로부터 사용자를 초기화하는 생성자2
  public AuthMemberDTO(
      String email,
      String name, String pw,
      String nickname, String gender,
      String mobile, String birth,
      boolean fromSocial,
      Collection<? extends GrantedAuthority> authorities,
      Map<String, Object> attr) {
    this(email, name, pw, nickname, gender, mobile, birth, fromSocial, authorities);
    this.attr = attr;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return this.attr;
  }
}
