package com.curation.snut.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/mcol")
public class McolController {

    @GetMapping("/main")
    public void main() {
        log.info("Member Collection Page....................");
    }

    @GetMapping("/note")
    public void note() {
        log.info("Member Note Page....................");
    }

    @GetMapping("/store/folder")
    public String folder() {
        log.info("Stored Folder Page......................................");
        return "mcol/store/folder";
    }

    @GetMapping("/store/cur")
    public String cur() {
        log.info("Stored Curation Page......................................");
        return "mcol/store/cur";
    }

    @GetMapping("/store/col")
    public String col() {
        log.info("Stored Curation Page......................................");
        return "/mcol/store/col";
    }

    @GetMapping("/mc")
    public String makeCuration() {
        log.info("Make Curation Page......................................");
        return "mcol/mc";
    }

    @GetMapping("/col")
    public String myCollection() {
        log.info("My Collection Page......................................");
        return "mcol/col";
    }

    @GetMapping("/show")
    public String showCollection() {
        log.info("Show Collection Page......................................");
        return "mcol/show";
    }

}
