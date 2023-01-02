package com.example.intern.web.controller;

import com.example.intern.web.auth.jwt.JwtProvider;
import com.example.intern.web.dto.fastener.CreateFastenerDto;
import com.example.intern.web.entity.Fastener;
import com.example.intern.web.exception.UserNotFoundFastener;
import com.example.intern.web.service.FastenerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"체결기 API"})
public class FastenerController {
    private final FastenerService fastenerService;
    private final JwtProvider jwtProvider;

    // 20체결기
    @ApiOperation(value = "체결기 데이터 조회")
    @GetMapping("/faslist")
    public ResponseEntity<List<CreateFastenerDto>> getFastener(HttpServletRequest request) {
        String token = jwtProvider.resolveToken(request);
        String userLicense = jwtProvider.getUserLicense(token);
        String substring = userLicense.substring(0, 1);

        if (!substring.contains("20")) {
            throw new UserNotFoundFastener();
        }

        List<CreateFastenerDto> list = fastenerService.getList(userLicense);
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "체결기 데이터 등록")
    @PostMapping("/add/fastener")
    public ResponseEntity<Fastener> addFastener(CreateFastenerDto createFastenerDto) {
        Fastener fastener = fastenerService.CreatFastener(createFastenerDto);
        return ResponseEntity.ok().body(fastener);
    }

//    @PostMapping("/repo2")
//    public ResponseEntity<List<CreateFastenerDto>> test2(HttpServletRequest request) {
//        String token = jwtProvider.resolveToken(request);
//        String userLicense = jwtProvider.getUserLicense(token);
//        String substring = userLicense.substring(0, 2);
//
//        if (!substring.contains("20")) {
//            throw new UserNotFoundFastener();
//        }
//
//        List<CreateFastenerDto> list = fastenerService.getList(userLicense);
//        return ResponseEntity.ok().body(list);
//    }
}
