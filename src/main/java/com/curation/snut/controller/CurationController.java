package com.curation.snut.controller;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.PageRequestDTO;
import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.service.CurationService;
import com.curation.snut.service.MemberService;
import com.curation.snut.service.SnutCollectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CurationController {
    private final CurationService curationService;
    private final SnutCollectionService snutCollectionService;
    private final MemberService memberService;

    // 성진

    @GetMapping(value = "/mcol/mc")
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
    public ResponseEntity dataSetBySearchWord(@RequestParam Map obj) {
        log.info("dataSetBySearchWord............");
        String searchWord = (String) obj.get("searchWord");
        log.info("searchWord >>>" + searchWord);
        List<CurationDTO> curations = curationService.getCurationsByWord(searchWord);
        List<SnutCollectionDTO> collections = snutCollectionService.getCollectionsByWord(searchWord);
        log.info("이 큐레이션은 비었나요? " + curations.isEmpty());
        log.info("이 컬렉션은 비었나요? " + collections.isEmpty());

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

    /////////////////////////////////////////////////////////////////////////////////

//    @GetMapping("/list")
//    public String CuList(Model model) {
//        // System.out.println(CuList(model));
//        List<CurationDTO> cuList = curationService.CuList();
//        model.addAttribute("cuList", cuList);
//        return "list.html";
//    };

//    public String CuList(Model model, String searchCurationTitle) {
//        if (searchCurationTitle != null) {;;
//            List<CurationDTO> searchCurationList = curationService.searchCurationTitle(searchCurationTitle);
//            model.addAttribute("cuList", searchCurationList);
//        }
//        return "list.html";
//
//    }

//    @RequestMapping(value = "/write", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String write3(@AuthenticationPrincipal MemberDTO memberDTO, Model model) {
//        model.addAttribute("member", memberDTO);
//        log.info("email........" + memberDTO);
//        return "/write";
//
//    }

//    @RequestMapping(value = "/write", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String curationWrite2(@RequestBody CurationDTO curationDTO) {
//        log.info("curationDTO >>>>>>>>>>>>> " + curationDTO);
//
//        curationService.write(curationDTO);
//        ra.addFlashAttribute("member", memberDTO);
//        log.info("email2........" + memberDTO);
//        return "redirect:/list";
//    }

//
//    @PostMapping("/write")
//    public String curationWrite2(CurationDTO curationDTO, @AuthenticationPrincipal MemberDTO memberDTO,
//                                 RedirectAttributes ra) {
//        curationService.write(curationDTO);
////        ra.addFlashAttribute("member", memberDTO);
//        log.info("email2........" + memberDTO);
//        return "redirect:/list";
//    }

//    @GetMapping({ "/read", "/modify" })
//    public void read(Long curationNo, @AuthenticationPrincipal AuthMemberDTO authMemberDTO, Model model) {
//        CurationDTO curationDTO = curationService.getCuration(curationNo);
//        log.info("email....." + authMemberDTO);
//        model.addAttribute("cuList", curationDTO);
//    }

//    @PostMapping("/modify")
//    public String modify(CurationDTO curationDTO, @AuthenticationPrincipal MemberDTO memberDTO, RedirectAttributes ra) {
        // log.info("modify read..........mno: " + dto.getCurationNo());
//        curationService.modify(curationDTO);
//        ra.addAttribute("curationNo", curationDTO.getCurationNo());
//        return "redirect:/read";
//    }

//    @GetMapping({ "/list/delete", "/read/delete" })
//    public String delete(Long id) {
//        curationService.delete(id);
//        return "redirect:/list";
//    }

    // 검색페이지로 이동(게시글의 태그 눌러서)
    // @GetMapping("/read/search")
    // public String search(@RequestParam("hashtag") String hashtag, Model model) {
    // model.addAttribute("hashtag", hashtag);
    // return "read/search";
    // }

    // 검색폼입력후 페이지이동
    // @PostMapping("/list/searchForm")
    // public String searchForm(String hashtag, RedirectAttributes ra) {
    // ra.addAttribute("hashtag", hashtag);
    // return "redirect:/read/search";
    // }
//    @GetMapping("/memberModify")
//    public void modify(@AuthenticationPrincipal AuthMemberDTO authMemberDTO, Model model) {
//        model.addAttribute("auth", authMemberDTO);
//        List<String> roleNames = new ArrayList<>();
//        authMemberDTO.getAuthorities().forEach(authority -> {
//            roleNames.add(authority.getAuthority());
//        });
//        model.addAttribute("roleNames", roleNames);
//    }

//    @PostMapping("/memberModify")
//    public String modifyForm(MemberDTO memberDTO, Model model) {
//        String result = "redirect:/detail";
//        log.info("memberDTO:" + memberDTO);
//        memberService.updateMemberDTO(memberDTO);
//        return result;
//    }

//    @PostMapping("/read/{curationNo}/likes")
//    public void likes(@PathVariable long curationNo, Authentication authentication) {
//        CurationLikeService.likes(curationNo, authentication.getName());
//        log.info("likes");
//    }
}
