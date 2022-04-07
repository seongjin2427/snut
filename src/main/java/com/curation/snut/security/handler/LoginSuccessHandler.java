package com.curation.snut.security.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curation.snut.security.dto.AuthMemberDTO;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirect = new DefaultRedirectStrategy();
    private PasswordEncoder passwordEncoder;

    public LoginSuccessHandler(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        AuthMemberDTO AuthMemberDTO = (AuthMemberDTO) authentication.getPrincipal();
        boolean passwordResult = passwordEncoder.matches("1", AuthMemberDTO.getPassword());

        if (passwordResult) {
            redirect.sendRedirect(request, response, "/member/modify");
            return;
        }

        List<String> roleNames = new ArrayList<>();
        AuthMemberDTO.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());
        });
        response.sendRedirect(request.getContextPath() + "/member/detail");
    }

}
