package com.example.intern2.web.controller;

import com.example.intern2.web.auth.jwt.JwtProvider;
import com.example.intern2.web.dto.BpmDto;
import com.example.intern2.web.entity.Bpm;
import com.example.intern2.web.service.BpmService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api")
@ApiOperation(value = "value= 회원 혈압 수동 입력 API",notes = "GetMapping /list 로그인시 발급 된 JWT 토큰값으로 사용자 확인하여 혈압 누적 데이터 출력")
@ApiResponses({ @ApiResponse(code = 200,message = "API 정상작동"),
                @ApiResponse(code = 500,message = "서버 에러")
})
public class BpmController {
    private final JwtProvider jwtProvider;

    private final BpmService bpmService;

    @PostMapping("/register")
    public ResponseEntity<Bpm> add(@RequestBody BpmDto bpmDto)
    {
        Bpm bpm = bpmService.input(bpmDto);
        return ResponseEntity.ok().body(bpm);
    }
    @GetMapping("/list")
    public ResponseEntity<List<BpmDto>> getList(HttpServletRequest request)//HttpServletRequest request)
    {

        String token =jwtProvider.resolveToken(request);
        log.info("token :{}",token);
        log.info("info={}",jwtProvider.getAuthentication(token));
        String userId = jwtProvider.getUserId(token);
        log.info("userId :{}",userId);
        List<BpmDto> list = bpmService.getList(userId);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/all")
    public List<Bpm> getList()
    {
        return bpmService.getList();
    }




}
