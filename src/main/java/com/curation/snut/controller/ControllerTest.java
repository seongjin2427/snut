package com.curation.snut.controller;

import java.util.List;

import com.curation.snut.dto.CommunityDTO;
import com.curation.snut.service.CommentService;
import com.curation.snut.service.CommunityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ControllerTest {
    private final CommentService commentService;
    private final CommunityService communityService;

    // @PreAuthorize("hasRole('ADMIN')")
    // @PreAuthorize("#Member != null && #Member.email eq \"123@123.123\"")

    @PreAuthorize("permitAll()")
    @GetMapping(value = "/test/commuList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommunityDTO>> testList(String searchTitle) {
        if (searchTitle != null) {
            List<CommunityDTO> searchCommunityList = communityService.searchTitle(searchTitle);
            return new ResponseEntity<>(searchCommunityList, HttpStatus.OK);
        } else {
            List<CommunityDTO> list = communityService.communityListWithCnt();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/test/commuList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testWrite(CommunityDTO communityDTO) {
        communityService.write(communityDTO);
        return new ResponseEntity<>("완료", HttpStatus.CREATED);
    }

    @GetMapping(value = "/test/commuList/delete")
    public ResponseEntity<String> testdelete(Long no) {
        communityService.delete(no);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
