// Authentication까지 보류

// package com.curation.snut.controller;

// import com.curation.snut.service.CuLikeService;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @RequiredArgsConstructor
// @RestController
// public class LikeApiController {
// private final CuLikeService cuLikeService;

// @PostMapping("/cuLike/{curationNo}")
// public ResponseEntity<String>addCuLike{
// @AuthenticationPrincipal MemberAdapter MemberAdapter,
// @PathVariable Long curationNo){
// bollean result =false;

// if(MemberAdapter != null){
// result = CuLikeService.addCuLike(MemberAdapter.getMember(),curationNo)''
// }
// return result ?
// new ResponseEntity<>(HttpStatus.OK)
// : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
// }
// }
// }
