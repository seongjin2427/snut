package com.curation.snut.controller;

import java.util.List;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.service.CurationService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping
@Log4j2
@RequiredArgsConstructor

public class CurationController {
    private CurationService curationService;

    @GetMapping("/list")
    public String CuList(Model model) {
        List<CurationDTO> cuList = curationService.cuList();
        model.addAttribute("cuList", cuList);
        return "list.html";
    };

    @PostMapping("/list")
    public String curationWrite(CurationDTO curationDTO) {
        log.info("writed....." + curationDTO);
        curationService.write(curationDTO);
        return "redirect:/curationList";
    }

    @GetMapping("/list/delete")
    public String delete(Long id) {
        curationService.delete(id);
        return "redirect:/list";
    }

}
