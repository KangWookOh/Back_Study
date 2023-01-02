//package com.example.intern.web.controller;
//
//import com.example.intern.web.dto.CreateMemberDto;
//import com.example.intern.web.entity.member.Member;
//import com.example.intern.web.repository.MemberRepository;
//import com.example.intern.web.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequiredArgsConstructor
//public class InController {
//
//    private final MemberService memberService;
//    private final MemberRepository memberRepository;
//
//    @GetMapping("/join")
//    public String join() { // 기본 페이지 리턴하는 코드( 메소드)
//        return "index";
//    }
//
//    @PostMapping("/join")
//    public String join(CreateMemberDto createMemberDto) { // service 로직에서 작성한 회원가입메소드를 이용하여 HTTP
//        // 통신을 하는 메소드
//        Member member = memberService.createMember(createMemberDto);
//        return "redirect:/";
//    }
//}
