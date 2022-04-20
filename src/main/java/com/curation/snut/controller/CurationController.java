package com.curation.snut.controller;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.repository.CurationRepository;
import com.curation.snut.repository.MemberCollectionLikeRepository;
import com.curation.snut.repository.MemberCurationLikeRepository;
import com.curation.snut.repository.SnutCollectionRepository;
import com.curation.snut.service.CurationService;
import com.curation.snut.service.HashTagService;
import com.curation.snut.service.SnutCollectionService;
import com.curation.snut.service.like.MemberCollectionLikeService;
import com.curation.snut.service.like.MemberCurationLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CurationController {

    private final CurationRepository curationRepository;
    private final SnutCollectionRepository snutCollectionRepository;
    private final CurationService curationService;
    private final SnutCollectionService snutCollectionService;
    private final HashTagService hashTagService;
    private final MemberCollectionLikeService memberCollectionLikeService;
    private final MemberCurationLikeService memberCurationLikeService;
    private final MemberCurationLikeRepository memberCurationLikeRepository;
    private final MemberCollectionLikeRepository memberCollectionLikeRepository;

    // 성진
    // 이메일로 큐레이션 리스트 모두 가져오기 - Make Collection.vue에서 사용 (컬렉션 만들기 페이지)
    @GetMapping(value = "/mcol/mc/em")
    public ResponseEntity getListByEmail(@RequestParam("email") String email) {

        log.info("getListByEmail >>>>>>>>>>> " + email);
        List<CurationDTO> culist = curationService.getCurationByEmail(email);
        log.info("getListByEmail >>>>>>>>>>> " + culist);

        return new ResponseEntity(culist, HttpStatus.OK);
    }

    // 이메일 기준으로 모든 큐레이션, 콜렉션 가져오기 - My Note.vue에서 사용 (나만의 기록 페이지)
    @GetMapping("/mcol/mn")
    public ResponseEntity getAllListByEmail(@RequestParam("email") String email) {

        log.info("getAllListByEmail >>>>>>>>>>> " + email);
        List<CurationDTO> culist = curationService.getCurationByEmail(email);
        List<SnutCollectionDTO> colList = snutCollectionService.getCollectionsByEmail(email);
        log.info("culist >>>>>>>>>>> " + culist);
        log.info("colList >>>>>>>>>>> " + colList);
        HashMap sendMap = new HashMap();
        sendMap.put("Curation", culist);
        sendMap.put("Collection", colList);

        return new ResponseEntity(sendMap, HttpStatus.OK);
    }

    // 큐레이션 ID값 기준으로 큐레이션 가져오기 - MakeColSave.vue에서 사용 (컬렉션 만들기 페이지)
    @RequestMapping(value = "/mcol/store", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CurationDTO cuListByCurationNo(@RequestParam Map body) {
        log.info("cuListByCurationNo............");
        log.info("no >>>" + body.get("curationId"));
        Long a = Long.parseLong((String) body.get("curationId"));
        return curationService.getCurationsByCurationNo(a);
    }

    // 검색단어 기준으로 컬렉션 및 큐레이션 데이터 가져오기 - SearchCollection.vue에서 사용 (검색 페이지)
    @GetMapping(value = "/main", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity dataSetBySearchWord(@RequestParam Map searchWord) {
        log.info("dataSetBySearchWord............");
        log.info("searchWord >>>" + searchWord);
        String word = (String) searchWord.get("word");
        log.info("searchWord >>>" + word);

        List<CurationDTO> curations = curationService.getCurationsByWord(word);
        List<SnutCollectionDTO> collections = snutCollectionService.getCollectionsByWord(word);
        log.info("이 큐레이션은 비었나요? " + curations.isEmpty());
        log.info("이 컬렉션은 비었나요? " + collections.isEmpty());

        hashTagService.upCountHashtag(word);

        Map a = new HashMap<>();
        a.put("Collection", collections);
        a.put("Curation", curations);

        return new ResponseEntity(a, HttpStatus.OK);
//        return new ResponseEntity(HttpStatus.OK);
    }

    // 큐레이션 등록하기 - MakeNote.vue에서 사용 (큐레이션 등록하기)
    @PostMapping(value = "/mcol/note/makenote/picture", consumes = MediaType.ALL_VALUE)
    public ResponseEntity curationRegister(@RequestBody CurationDTO curationDTO) {
        log.info("curationDTO >>>> " + curationDTO);
        Long curationNo = curationService.register(curationDTO);

        return new ResponseEntity(curationNo, HttpStatus.OK);
    }

    // 컬렉션 등록하기 - MakeCollection.vue에서 사용 (컬렉션 등록하기)
    @PostMapping(value = "/mcol/mc", consumes = MediaType.ALL_VALUE)
    public ResponseEntity collectionRegister(@RequestBody SnutCollectionDTO snutCollectionDTO) {
        log.info("collectionDTO >>>>>>>> " + snutCollectionDTO);
        Long collectionNo = snutCollectionService.snutCollectionRegister(snutCollectionDTO);

        return new ResponseEntity(collectionNo, HttpStatus.OK);
    }



    // 좋아요 구간
    // 컬렉션 좋아요 등록
    @PostMapping("/col/likes")
    public String collectionlikes(@RequestBody Map data) {
        log.info("likes >>>>>> " + data);
        Long no = Long.valueOf(String.valueOf(data.get("no")));
        String email = (String) data.get("email");

        if (memberCollectionLikeRepository.findCollectionByEmailAndCollectionNo(no, email) == null) {
            memberCollectionLikeService.likes(no, email);
            Optional<SnutCollection> col = snutCollectionRepository.findById(no);
            col.get().setLike(true);
            snutCollectionRepository.save(col.get());

            return "좋아요 완료";
        }
        return "중복";
    }
    // 컬렉션 좋아요 해제
    @DeleteMapping("/col/unlikes")
    public String collectionUnlikes(@RequestParam Map data) {
        log.info("likes >>>>>> " + data);
        Long no = Long.valueOf(String.valueOf(data.get("no")));
        String email = (String) data.get("email");
        if (memberCollectionLikeRepository.findCollectionByEmailAndCollectionNo(no, email) != null) {
            memberCollectionLikeService.unlikes(no, email);
            Optional<SnutCollection> col = snutCollectionRepository.findById(no);
            col.get().setLike(false);
            snutCollectionRepository.save(col.get());
            return "좋아요 해제";
        }
        return "좋아요 해제할 데이터 없음";
    }
    // 큐레이션 좋아요 등록
    @PostMapping("/cu/likes")
    public String curationlikes(@RequestBody Map data) {
        log.info("likes >>>>>> " + data);
        Long no = Long.valueOf(String.valueOf(data.get("no")));
        String email = (String) data.get("email");
        if (memberCurationLikeRepository.findCurationByEmailAndCurationNo(no, email) == null) {
            System.out.println("???? >>>>>>> " + memberCurationLikeRepository.findCurationByEmailAndCurationNo(no, email) == null);
            memberCurationLikeService.likes(no, email);
            Optional<Curation> cu = curationRepository.findById(no);
            cu.get().setLike(true);
            curationRepository.save(cu.get());
            return "좋아요 완료";
        }
        return "중복";
    }
    // 큐레이션 좋아요 해제
    @DeleteMapping("/cu/unlikes")
    public String curationUnlikes(@RequestParam Map data) {
        log.info("likes >>>>>> " + data);
        Long no = Long.valueOf(String.valueOf(data.get("no")));
        String email = (String) data.get("email");
        if (memberCurationLikeRepository.findCurationByEmailAndCurationNo(no, email) != null) {
            memberCurationLikeService.unlikes(no, email);
            Optional<Curation> cu = curationRepository.findById(no);
            cu.get().setLike(false);
            curationRepository.save(cu.get());
            return "좋아요 해제 완료";
        }
        return "좋아요 해제할 데이터 없음";
    }

}
