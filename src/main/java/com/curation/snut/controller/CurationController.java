package com.curation.snut.controller;

import java.util.ArrayList;
import java.util.List;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.MemberDTO;
import com.curation.snut.security.dto.AuthMemberDTO;
import com.curation.snut.service.CurationService;
import com.curation.snut.service.MemberService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CurationController {
    private final CurationService curationService;
    private final MemberService memberService;

    @GetMapping("/list")
    public String CuList(Model model) {
        // System.out.println(CuList(model));
        List<CurationDTO> cuList = curationService.CuList();
        model.addAttribute("cuList", cuList);
        log.info("cuList.,............." + cuList);
        return "list.html";
    };

    public String CuList(Model model, String searchCurationTitle) {
        if (searchCurationTitle != null) {
            List<CurationDTO> searchCurationList = curationService.searchCurationTitle(searchCurationTitle);
            model.addAttribute("cuList", searchCurationList);
        }
        return "list.html";

    }

    @PostMapping("/write")
    public String curationWrite2(CurationDTO curationDTO) {
        // log.info("write....." + curationDTO);
        curationService.write(curationDTO);
        return "redirect:/list";
    }

    @GetMapping({ "/read", "/modify" })
    public void read(Long curationNo, Model model) {
        log.info("curationNo : " + curationNo);
        CurationDTO curationDTO = curationService.getCuration(curationNo);
        model.addAttribute("cuList", curationDTO);

    }

    @PostMapping("/modify")
    public String modify(CurationDTO curationDTO, RedirectAttributes ra) {
        // log.info("modify read..........mno: " + dto.getCurationNo());
        curationService.modify(curationDTO);
        ra.addAttribute("curationNo", curationDTO.getCurationNo());
        return "redirect:/read";
    }

    @GetMapping({ "/list/delete", "/read/delete" })
    public String delete(Long id) {
        curationService.delete(id);
        return "redirect:/list";
    }

    // 검색페이지로 이동(게시글의 태그 눌러서)
    // @GetMapping("/read/search")
    // public String search(@RequestParam("hashtag") String hashtag, Model model) {
    // model.addAttribute("hashtag", hashtag);
    // return "read/search";
    // }

    // 검색폼입력후 페이지이동
    // @PostMapping("/list/searchForm")
    // public String searchForm(String hashtag, RedirectAttributes ra) {
    // ra.addAttribute("hashtag", hashtag);
    // return "redirect:/read/search";
    // }
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
        log.info("memberDTO:" + memberDTO);
        memberService.updateMemberDTO(memberDTO);
        return result;
    }
}
