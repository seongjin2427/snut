package com.curation.snut.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({ "", "/" })
    public String home() {
        return "index";
=======
import com.curation.snut.entity.Member;
import com.curation.snut.repository.MemberRepository;
import com.curation.snut.security.role.MemberRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;

        @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map body){
        log.info("body >>>>> " + body);

        String email = body.get("email").toString();
        String pw = body.get("pw").toString();
        String nickname = body.get("nickname").toString();

        Member member = Member.builder()
                .email(email)
                .name("456")
                .pw(passwordEncoder.encode(pw))
                .mobile("456456")
                .birth("456")
                .gender("male")
                .nickname(nickname)
                .build();
        member.addMemberRole(MemberRole.USER);

        memberRepository.save(member);

        String list = "된건가?";
        return new ResponseEntity<>(list, HttpStatus.OK);
>>>>>>> ca64f923ad2d113526a840b7f662fa703d16aa2f
    }
}
