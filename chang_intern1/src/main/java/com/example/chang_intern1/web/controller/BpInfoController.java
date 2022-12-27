package com.example.chang_intern1.web.controller;

import com.example.chang_intern1.web.auth.jwt.JwtTokenProvider;
import com.example.chang_intern1.web.entity.Bpm;
import com.example.chang_intern1.web.entity.dto.BpmDto;
import com.example.chang_intern1.web.service.BpmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BpInfoController {
    private final BpmService bpmService;

    private final JwtTokenProvider jwtTokenProvider;

//    @PostMapping("/bpm")
//    public ResponseEntity<Bpm> info(@RequestBody BpmDto bpmDto)
//    {
//        Bpm info = bpmService.InfoByUser(bpmDto);
//        return ResponseEntity.ok().body(info);
//    }

    @GetMapping("/list")
    public ResponseEntity<List<BpmDto>> list(HttpServletRequest request) {
        String token  = jwtTokenProvider.resolveToken(request);
        String userId = jwtTokenProvider.getUserPk(token);
        List<BpmDto> getList = bpmService.InfoByUser(userId);

        return ResponseEntity.ok().body(getList);

    }







}
