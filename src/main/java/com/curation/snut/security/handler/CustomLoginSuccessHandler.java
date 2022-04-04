package com.curation.snut.security.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curation.snut.security.dto.AuthMemberDTO;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
  private RedirectStrategy redirect = new DefaultRedirectStrategy();
  private PasswordEncoder passwordEncoder;

  public CustomLoginSuccessHandler(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
      HttpServletResponse response, Authentication auth)
      throws IOException, ServletException {
    log.warn("Login Success");
    AuthMemberDTO authMemberDTO = (AuthMemberDTO) auth.getPrincipal();
    boolean fromSocial = authMemberDTO.isFromSocial();
    log.info("authMemberDTO:" + authMemberDTO);
    boolean pwResult = passwordEncoder.matches("1", authMemberDTO.getPw());
    log.info("DTO.getPw:" + authMemberDTO.getPw());

    if (fromSocial && pwResult) {
      redirect.sendRedirect(request, response, "/list");
      return;
    }
    List<String> roleNames = new ArrayList<>();
    authMemberDTO.getAuthorities().forEach(authority -> {
      roleNames.add(authority.getAuthority());
    });
    log.warn("ROLE NAMES: " + roleNames);
    if (roleNames.contains("ROLE_ADMIN")) {
      response.sendRedirect(request.getContextPath() + "/@@@@@");
      return;
    }
    if (roleNames.contains("ROLE_MEMBER")) {
      response.sendRedirect(request.getContextPath() + "/@@@@@");
      return;
    }
    if (roleNames.contains("ROLE_USER")) {
      response.sendRedirect(request.getContextPath() + "/@@@@@");
      return;
    }
    response.sendRedirect(request.getContextPath() + "/@@@@@");
  }

}