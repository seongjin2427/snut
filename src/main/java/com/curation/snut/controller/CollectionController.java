package com.curation.snut.controller;

import com.curation.snut.dto.CollectionDTO;
import com.curation.snut.service.CollectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CollectionController {

    private final CollectionService collectionService;

    @GetMapping(value = "/get/{userNum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CollectionDTO>> getList(@PathVariable("userNum") String userNum) {

        log.info("list........................");
        log.info("userNum........................" + userNum);
        List<CollectionDTO> collectionDTOList = collectionService.getListOfSnutMember("user" + userNum + "@naver.com");

        return new ResponseEntity<>(collectionDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/col/{searchWord}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CollectionDTO>> getCollectionListContainsWithSearchWord(@PathVariable String searchWord) {
        log.info("getCollectionListContainsWithSearchWord.............");
        log.info("searchWord............." + searchWord);
        List<CollectionDTO> collectionDTOList = collectionService.getListContainsSearchWord(searchWord);

        return new ResponseEntity<>(collectionDTOList, HttpStatus.OK);
    }

}
