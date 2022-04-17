package com.curation.snut.controller;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.PageRequestDTO;
import com.curation.snut.service.CurationService;
import com.curation.snut.service.MemberService;
import com.curation.snut.service.SnutCollectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final CurationService curationService;
    private final SnutCollectionService snutCollectionService;

        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody Map body){
            log.info("body >>>>> " + body);
            memberService.register(body);
            return new ResponseEntity<>("등록 완료", HttpStatus.OK);
        }

        @GetMapping("/ucol")
        public ResponseEntity getCurationDataInCollection(@RequestParam("collectionNo") Long collectionNo) {
            log.info("request collectionNo >>>>>>>>>>> " + collectionNo);
            List<CurationDTO> curationDTOList = curationService.getCurationsByCollectionNo(collectionNo);

            return new ResponseEntity(curationDTOList, HttpStatus.OK);
        }

        @GetMapping(value = "/main/hot")
        public ResponseEntity getCollectionPoPularList(PageRequestDTO pageRequestDTO) {
            log.info("list............................." + pageRequestDTO);

            return new ResponseEntity<>(snutCollectionService.getPopularCollection(pageRequestDTO), HttpStatus.OK);
        }
}
