//package com.example.intern.web.controller;
//
//import com.example.intern.web.dto.CreateMemberDto;
//import com.example.intern.web.entity.member.Member;
//import com.example.intern.web.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController // return 값을 json방식으로 파싱해주는 어노테이션(라이브러리)
//@RequiredArgsConstructor// 의존성 주입도와주는 어노테이션(라이브러리)
//public class ApiController {
//
//     private final MemberService memberService; // service 로직을 사용하기 위해 선언
//
////    @PostMapping("/api/join")
////    public Member join(@RequestBody CreateMemberDto createMemberDto) { // service 로직에서 작성한 회원가입메소드를 이용하여 HTTP
////        // 통신을 하는 메소드
////        return memberService.createMember(createMemberDto);
////    }
//
//    @GetMapping("/joinlist") // 회원가입 자의 정보를 JSON 방식으로 가져 오는 API
//    public List<CreateMemberDto> getMembers() {
//        List<Member> members = memberService.getList();
//        List<CreateMemberDto> collect = members.stream()
//                .map(m -> new CreateMemberDto(m.getLoginId(), m.getUsername(),
//                        m.getPassword(), m.getSex(), m.getAge()))
//                .collect(Collectors.toList());
//
//        return collect; // service class 의 로직을 가져와 주는 코드
//    }
//}
