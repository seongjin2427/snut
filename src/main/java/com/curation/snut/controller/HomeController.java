package com.curation.snut.controller;

import com.curation.snut.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
public class HomeController {

//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping({ "", "/" })
//    public String home() {
//        return "index";
//    }

    private final MemberService memberService;

        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody Map body){
        log.info("body >>>>> " + body);

        memberService.register(body);

        return new ResponseEntity<>("등록 완료", HttpStatus.OK);
    }
}
