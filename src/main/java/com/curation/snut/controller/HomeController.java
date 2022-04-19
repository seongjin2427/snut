package com.curation.snut.controller;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.PageRequestDTO;
import com.curation.snut.service.CurationService;
import com.curation.snut.service.SnutCollectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class HomeController {

    private final CurationService curationService;
    private final SnutCollectionService snutCollectionService;

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
