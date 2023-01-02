//package com.example.intern.web.repository;
//
//import com.example.intern.web.dto.CreateMemberDto;
//import com.example.intern.web.entity.member.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.Optional;
//
//public interface MemberRepository extends JpaRepository<Member, Integer> {
//    // 기본적인 crud 사용하게 해주는 interface
//    Member findByUsername(String username);
//
//    boolean existsByUsername(String username);
//    Optional<Member> findByLoginId(String loginId);
//}
