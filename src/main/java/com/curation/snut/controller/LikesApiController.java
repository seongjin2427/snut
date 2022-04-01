// Authentication까지 보류

// package com.curation.snut.controller;

// import com.curation.snut.service.CulikesService;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @RequiredArgsConstructor
// @RestController
// public class LikesApiController {
// private final CulikesService cuLikesService;

// @PostMapping("/cuLikes/{curationNo}")
// public ResponseEntity<String>addCuLikes{
// @AuthenticationPrincipal MemberAdapter MemberAdapter,
// @PathVariable Long curationNo){
// boolean result =false;

// if(MemberAdapter != null){
// result = CulikesService.addCuLikes(MemberAdapter.getMember(),curationNo)''
// }
// return result ?
// new ResponseEntity<>(HttpStatus.OK)
// : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
// }
// }
// }
