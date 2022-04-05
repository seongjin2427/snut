package com.curation.snut.controller;

import java.util.ArrayList;
import java.util.List;

import com.curation.snut.dto.MemberDTO;
import com.curation.snut.security.dto.AuthMemberDTO;
import com.curation.snut.service.MemberService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("login")
  public void login() {
    log.info("login get...");
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/detail")
  public void all(Model model, @AuthenticationPrincipal AuthMemberDTO authMemberDTO) {
    model.addAttribute("auth", authMemberDTO);
  }

  @GetMapping("/memberModify")
  public void modify(@AuthenticationPrincipal AuthMemberDTO authMemberDTO, Model model) {
    model.addAttribute("auth", authMemberDTO);
    List<String> roleNames = new ArrayList<>();
    authMemberDTO.getAuthorities().forEach(authority -> {
      roleNames.add(authority.getAuthority());
    });
    model.addAttribute("roleNames", roleNames);
  }

  @PostMapping("/memberModify")
  public String modifyForm(MemberDTO memberDTO, Model model) {
    String result = "redirect:/detail";
    memberService.updateMemberDTO(memberDTO);
    return result;
  }
}
