package com.curation.snut.controller;

import java.util.List;
import java.util.Map;

import com.curation.snut.dto.CommuJoinDTO;
import com.curation.snut.dto.CommunityDTO;
import com.curation.snut.entity.CommuJoin;
import com.curation.snut.service.CommuJoinService;
import com.curation.snut.service.CommuJoinTempService;
import com.curation.snut.service.CommunityService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;
    private final CommuJoinTempService commuJoinTempService;
    private final CommuJoinService commuJoinService;

    @GetMapping(value = "/commuList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommunityDTO>> commuList(String searchTitle) {
        if (searchTitle != null) {
            List<CommunityDTO> searchCommunityList = communityService.searchTitle(searchTitle);
            return new ResponseEntity<>(searchCommunityList, HttpStatus.OK);
        } else {
            List<CommunityDTO> list = communityService.communityListWithCnt();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/commuList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> commuReg(CommunityDTO communityDTO) {
        communityService.write(communityDTO);
        return new ResponseEntity<>("완료", HttpStatus.CREATED);
    }

    @PostMapping(value = "/commuList/delete")
    public ResponseEntity<String> testdelete(@RequestBody Map body) {
        String memberEmail = body.get("memberEmail").toString();
        String commuEmail = body.get("commuEmail").toString();
        Long commuNo = Long.valueOf(body.get("commuNo").toString());

        if (memberEmail == commuEmail) {
            communityService.delete(commuNo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("권한없음", HttpStatus.OK);
        }

    }

    @PostMapping(value = "/commuJoinApply")
    public ResponseEntity<String> commuJoinApply(@RequestBody Map body) {
        commuJoinTempService.joinApply(body);
        return new ResponseEntity<>("신청완료", HttpStatus.OK);
    }

    @PostMapping(value = "/commuJoinAccept")
    public ResponseEntity<?> commuJoinAccept(CommuJoinDTO commuJoinDTO) {
        commuJoinService.joinAccept(commuJoinDTO);
        commuJoinTempService.joinAcceptAfterProcess(commuJoinDTO);
        return new ResponseEntity<>("수락 완료", HttpStatus.OK);
    }

    @GetMapping(value = "/commuJoinList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommuJoin>> commuJoinList(@RequestBody Map body) {
        String memberEmail = body.get("memberEmail").toString();
        List<CommuJoin> joinList = commuJoinService.joinList(memberEmail);
        return new ResponseEntity<>(joinList, HttpStatus.OK);
    }

    @PostMapping(value = "/commuJoinList/commuJoinDelete")
    public ResponseEntity<?> commuJoinDelete(CommuJoinDTO commuJoinDTO) {
        commuJoinService.joinDelete(commuJoinDTO);
        return new ResponseEntity<>("강퇴 완료", HttpStatus.OK);
    }

}
