package com.curation.snut.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/col")
@Log4j2
public class ColController {

    @GetMapping("/col")
    public void col() {
        log.info("Collection Search Page...........................");
    }

    @GetMapping("/show")
    public void show() {
        log.info("Select Curation Page...........................");
    }
}
