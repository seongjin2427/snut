package com.curation.snut.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample/")
@Log4j2
public class SampleController {
    @GetMapping("/all")
    public void exAll() {
        log.info("exAll.......");
    }
}
