package com.example.intern.web.controller;

import com.example.intern.web.auth.jwt.JwtProvider;
import com.example.intern.web.dto.bmember.CreateSign;
import com.example.intern.web.dto.bmember.LoginInfo;
import com.example.intern.web.dto.bmember.LoginResponse;
import com.example.intern.web.entity.BusinessMember;
import com.example.intern.web.repository.BusinessMemberRepository;
import com.example.intern.web.repository.PostureRepository;
import com.example.intern.web.service.businessmember.BusinessMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Api(tags = {"사용자 API"})
public class MemberController {

    private final BusinessMemberService businessMemberService;
    private final JwtProvider jwtProvider;

    @ApiOperation(value = "사용자 등록")
    @PostMapping("/add")
    public ResponseEntity<BusinessMember> add(@RequestBody CreateSign createSign) throws IOException {
        BusinessMember bm = businessMemberService.signUp(createSign);

        return ResponseEntity.ok().body(bm);
    }

    @ApiOperation(value = "사용자 로그인")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CreateSign createSign) throws Exception {
        businessMemberService.loginInfo(createSign);
        String token = jwtProvider.createToken(createSign.getLicense(), createSign.getRoles());

        // 8.1 (월) -> csv 다운은 사용자 id 값으로 repository 조회
        // CSV 다운을 위해, 토큰만 전송해도 프론트에서 id 값을 가져올수 있냐? ----> body 에 토큰만 전송
        // 토큰으로 사용자 key_id 를 못가져온다 ---> LoginResponse 로 토큰과 사용자 정보 같이 전달

        //LoginResponse bodyResponse = new LoginResponse();
        //bodyResponse.setLoginInfo(loginInfo);
        //bodyResponse.setToken(token);
        //return ResponseEntity.ok().body(bodyResponse);
        return ResponseEntity.ok(token);
    }
}
