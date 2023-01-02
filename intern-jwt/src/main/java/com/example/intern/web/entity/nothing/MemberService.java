//package com.example.intern.web.service;
//
//import com.example.intern.web.dto.CreateMemberDto;
//import com.example.intern.web.entity.member.Member;
//import com.example.intern.web.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class MemberService {
//
//    private final MemberRepository memberRepository;
////    private final BCryptPasswordEncoder passwordEncoder;
//
//    // 회원가입
////    public Member createMember(CreateMemberDto createMemberDto) {
////        // 멤버 회원가입을 위한 로직
////        createMemberDto.setPassword(passwordEncoder.encode(createMemberDto.getPassword()));
////        Member member = new Member(createMemberDto);
////        validateDuplicateMember(member);
////        return memberRepository.save(member);
////    }
//
//    public List<Member> select() {
//        List<Member> all = memberRepository.findAll();
//        return all;
//    }
//
//    public List<Member> getList() {
//        //회원가입된 멤버의 데이터를 가져와주는 로직
//        return memberRepository.findAll();
//    }
//
//    public void validateDuplicateMember(Member member) {
//        Optional<Member> findLoginId = memberRepository.findByLoginId(member.getLoginId());
//        if (!findLoginId.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 아이디");
//        }
//    }
//}
