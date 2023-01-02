package com.example.intern.web.controller;

import com.example.intern.web.auth.jwt.JwtProvider;
import com.example.intern.web.dto.posture.CreatePostureDto;
import com.example.intern.web.entity.Posture;
import com.example.intern.web.exception.UserNotFoundPosture;
import com.example.intern.web.service.PostureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"자세차 API"})
public class PostureController {

    private final PostureService postureService;
    private final JwtProvider jwtProvider;

    @ApiOperation(value = "자세차 데이터 등록")
    @PostMapping("/add/posture")
    public ResponseEntity<Posture> addPosture(CreatePostureDto createPostureDto) {
        Posture posture = postureService.createPosture(createPostureDto);
        return ResponseEntity.ok().body(posture);
    }

    // 10 자세차
    @ApiOperation(value = "자세차 데이터 조회")
    @GetMapping("/poslist")
    public ResponseEntity<List<CreatePostureDto>> getPosture(HttpServletRequest request) {
        String token = jwtProvider.resolveToken(request);
        String userLicense = jwtProvider.getUserLicense(token);
        String substring = userLicense.substring(0, 2);

        log.info("정보 : {}", userLicense);
        log.info("정보 : {}, ", substring);

        if (!substring.contains("10")) {
            throw new UserNotFoundPosture();
        }

        List<CreatePostureDto> list = postureService.getList(userLicense);
        return ResponseEntity.ok().body(list);
    }

//    @PostMapping("/repo")
//    public ResponseEntity<List<CreatePostureDto>> test2(HttpServletRequest request) {
//        String token = jwtProvider.resolveToken(request);
//        String userLicense = jwtProvider.getUserLicense(token);
//        String substring = userLicense.substring(0, 2);
//
//        log.info("정보 : {}", userLicense);
//        log.info("정보 : {}, ", substring);
//
//        if (!substring.contains("10")) {
//            throw new UserNotFoundPosture();
//        }
//
//        List<CreatePostureDto> list = postureService.getList(userLicense);
//        return ResponseEntity.ok().body(list);
//    }
//

//    @GetMapping("/repo/{id}")
//    public ResponseEntity<List<CreatePostureDto>> test(@PathVariable("id") Long id, HttpSession session) throws IOException {
//        List<CreatePostureDto> list = postureService.getList(id, session);
//        return ResponseEntity.ok().body(list);
//    }
}
