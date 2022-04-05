package com.curation.snut.controller;

import java.util.List;

import com.curation.snut.dto.CommunityDTO;
import com.curation.snut.repository.CommunityRepository;
import com.curation.snut.service.CommentService;
import com.curation.snut.service.CommunityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
public class ControllerTest {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommunityService communityService;

    @RequestMapping(value = "/test/commuList", method = RequestMethod.GET)
    public List<CommunityDTO> test() throws Exception {
        return communityService.communityListWithCnt();
    }

}
