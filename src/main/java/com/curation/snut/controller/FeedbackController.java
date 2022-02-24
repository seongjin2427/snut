package com.curation.snut.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fd")
@Log4j2
public class FeedbackController {

    @GetMapping("/info")
    public void info() {
        log.info("Feedback - Information Page...........................");
    }

    @GetMapping("/faq")
    public void faq() {
        log.info("Feedback - FAQ Page...........................");
    }

    @GetMapping("/send")
    public void send() {
        log.info("Feedback - send Page...........................");
    }
}
