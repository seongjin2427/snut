package com.curation.snut.controller;

import java.util.List;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.service.CurationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping
@Log4j2
@RequiredArgsConstructor

public class CurationController {
    private final CurationService curationService;

    @GetMapping("/list")
    public String CuList(Model model) {
        // System.out.println(CuList(model));
        List<CurationDTO> cuList = curationService.CuList();
        model.addAttribute("cuList", cuList);
        log.info("cuList.,............." + cuList);
        return "list.html";
    };

    @GetMapping("/write")
    public void write() {
    }

    @PostMapping("/write")
    public String curationWrite2(CurationDTO curationDTO) {
        // log.info("write....." + curationDTO);
        curationService.write(curationDTO);
        return "redirect:/list";
    }

    @GetMapping({ "/post", "/modify" })
    public void read(Long curationNo, Model model) {
        // log.info("curationNo : " + curationNo);
        CurationDTO curationDTO = curationService.getCuration(curationNo);
        model.addAttribute("dto", curationDTO);

    }

    @PostMapping("/modify")
    public String modify(CurationDTO dto, RedirectAttributes ra) {
        // log.info("modify post..........mno: " + dto.getCurationNo());
        curationService.modify(dto);
        ra.addAttribute("mno", dto.getCurationNo());
        return "redirect:/curation/post";
    }

    @GetMapping("/list/delete")
    public String delete(Long id) {
        curationService.delete(id);
        return "redirect:/list";
    }

}
