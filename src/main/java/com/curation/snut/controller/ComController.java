package com.curation.snut.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/com")
public class ComController {

    @GetMapping("/com")
    public void com() {
        log.info("Community Page.................................");
    }

    @GetMapping("/sc")
    public void sc() {
        log.info("Community Search Page.................................");
    }
    @GetMapping("/board")
    public void board() {
        log.info("Community Search Page.................................");
    }
    @GetMapping("/mcom")
    public void mcom() {
        log.info("Community Search Page.................................");
    }
}
