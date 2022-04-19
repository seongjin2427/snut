package com.curation.snut.controller;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.repository.CurationRepository;
import com.curation.snut.repository.MemberCollectionLikeRepository;
import com.curation.snut.repository.MemberCurationLikeRepository;
import com.curation.snut.repository.SnutCollectionRepository;
import com.curation.snut.security.util.JWTUtil;
import com.curation.snut.service.CurationService;
import com.curation.snut.service.HashTagService;
import com.curation.snut.service.like.MemberCollectionLikeService;
import com.curation.snut.service.SnutCollectionService;
import com.curation.snut.service.like.MemberCurationLikeService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private JWTUtil jwtUtil;
    // 성진

    @GetMapping(value = "/mcol/mc/em")
    public ResponseEntity getListByEmail(@RequestParam("email") String email) {

        log.info("getListByEmail >>>>>>>>>>> " + email);
        List<CurationDTO> culist = curationService.getCurationByEmail(email);
        log.info("getListByEmail >>>>>>>>>>> " + culist);

        return new ResponseEntity(culist, HttpStatus.OK);
    }

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

    @RequestMapping(value = "/mcol/store", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CurationDTO cuListByCurationNo(@RequestParam Map body) {
        log.info("cuListByCurationNo............");
        log.info("no >>>" + body.get("curationId"));
        Long a = Long.parseLong((String) body.get("curationId"));
        return curationService.getCurationsByCurationNo(a);
    }


    @RequestMapping(value = "/main", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity dataSetBySearchWord(@RequestParam("searchWord") String searchWord) {
        log.info("dataSetBySearchWord............");
        log.info("searchWord >>>" + searchWord);
        List<CurationDTO> curations = curationService.getCurationsByWord(searchWord);
        List<SnutCollectionDTO> collections = snutCollectionService.getCollectionsByWord(searchWord);
        log.info("이 큐레이션은 비었나요? " + curations.isEmpty());
        log.info("이 컬렉션은 비었나요? " + collections.isEmpty());

        hashTagService.upCountHashtag(searchWord);

        Map a = new HashMap<>();
        a.put("Collection", collections);
        a.put("Curation", curations);

        return new ResponseEntity(a, HttpStatus.OK);
    }

    @PostMapping(value = "/mcol/note/makenote/picture", consumes = MediaType.ALL_VALUE)
    public ResponseEntity curationRegister(@RequestBody CurationDTO curationDTO) {
        log.info("curationDTO >>>> " + curationDTO);
        Long curationNo = curationService.register(curationDTO);
//        Long curationNo = 1L;
        return new ResponseEntity(curationNo, HttpStatus.OK);
    }

    @PostMapping(value = "/mcol/mc", consumes = MediaType.ALL_VALUE)
    public ResponseEntity collectionRegister(@RequestBody SnutCollectionDTO snutCollectionDTO) {
        log.info("collectionDTO >>>>>>>> " + snutCollectionDTO);
        Long collectionNo = snutCollectionService.snutCollectionRegister(snutCollectionDTO);

//        return new ResponseEntity(collectionNo, HttpStatus.OK);
        return new ResponseEntity(collectionNo, HttpStatus.OK);
    }


    // 좋아요 구간
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
            System.out.println("cu다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ   " + cu.get());
            curationRepository.save(cu.get());
            return "좋아요 완료";
        }
        return "중복";
    }
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
