package com.example.intern.web.controller;

import com.example.intern.web.entity.BusinessMember;
import com.example.intern.web.entity.Fastener;
import com.example.intern.web.entity.Posture;
import com.example.intern.web.repository.BusinessMemberRepository;
import com.example.intern.web.repository.FastenerRepository;
import com.example.intern.web.repository.PostureRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"사용자, 데이터 모두 조회"})
public class AdminController {
    private final BusinessMemberRepository businessMemberRepository;
    private final FastenerRepository fastenerRepository;
    private final PostureRepository postureRepository;

    @GetMapping("/admin/member/list")
    public ResponseEntity<List<BusinessMember>> getListM() {
        List<BusinessMember> all = businessMemberRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/admin/fas/list")
    public ResponseEntity<List<Fastener>> getListF() {
        List<Fastener> all = fastenerRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/admin/pos/list")
    public ResponseEntity<List<Posture>> getListP() {
        List<Posture> all = postureRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
