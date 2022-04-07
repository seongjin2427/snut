package com.curation.snut.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @PreAuthorize("hasRole('USER')")
    @RequestMapping({ "", "/" })
    public String home() {
        return "index";
    }
}
