package com.example.intern2.web.controller;

import com.example.intern2.web.auth.jwt.JwtProvider;
import com.example.intern2.web.dto.BpmDto;
import com.example.intern2.web.entity.Bpm;
import com.example.intern2.web.service.BpmService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api")
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
        String userId = jwtProvider.getUserId(token);
        List<BpmDto> list = bpmService.getList(userId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/all")
    public List<Bpm> getList()
    {
        return bpmService.getList();
    }




}
