package com.curation.snut.controller;

import java.util.List;

import com.curation.snut.dto.MemberDTO;
import com.curation.snut.dto.NoteDTO;
import com.curation.snut.security.dto.AuthMemberDTO;
import com.curation.snut.service.NoteService;

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
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/noteList")
    public String NoteList(Model model) {
        // System.out.println(NoteList(model));
        List<NoteDTO> noteList = noteService.NoteList();
        model.addAttribute("noteList", noteList);
        return "noteList.html";
    };

    @GetMapping("/noteWrite")
    public String noteWrite(@AuthenticationPrincipal MemberDTO memberDTO, Model model) {
        model.addAttribute("member", memberDTO);
        log.info("email........" + memberDTO);
        return "/noteWrite";

    }

    @PostMapping("/noteWrite")
    public String noteWrite2(NoteDTO noteDTO, @AuthenticationPrincipal MemberDTO memberDTO,
            RedirectAttributes ra) {
        noteService.noteWrite(noteDTO);
        ra.addFlashAttribute("member", memberDTO);
        log.info("email2........" + memberDTO);
        return "redirect:/noteList";
    }

    @GetMapping({ "/noteRead", "/noteModify" })
    public void noteRead(Long noteNo, @AuthenticationPrincipal AuthMemberDTO authMemberDTO, Model model) {
        NoteDTO noteDTO = noteService.getNote(noteNo);
        log.info("email....." + authMemberDTO);
        model.addAttribute("noteList", noteDTO);

    }

    @PostMapping("/noteModify")
    public String noteModify(NoteDTO noteDTO, @AuthenticationPrincipal MemberDTO memberDTO, RedirectAttributes ra) {
        // log.info("modify read..........mno: " + dto.getCurationNo());
        noteService.noteModify(noteDTO);
        ra.addAttribute("noteNo", noteDTO.getNoteNo());
        return "redirect:/noteRead";
    }

    @GetMapping({ "/noteList/noteDelete", "/noteRead/noteDelete" })
    public String noteDelete(Long id) {
        noteService.noteDelete(id);
        return "redirect:/noteList";
    }
}
