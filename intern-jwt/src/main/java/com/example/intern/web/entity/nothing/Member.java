//package com.example.intern.web.entity.member;
//
//import com.example.intern.web.dto.CreateMemberDto;
//import com.example.intern.web.entity.Fastener;
//import com.example.intern.web.entity.Posture;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "member")
//@NoArgsConstructor
//@Getter
////DB columns 생성 로직
//public class Member {
//
//    @Id // PK선언
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//
//    private String loginId;
//    private String username;
//    private String password;
//    private int age;
//    private String sex;
//
////    @OneToMany(mappedBy = "member")
////    private List<Fastener> fastenerList;
////
////    @OneToMany(mappedBy = "member")
////    private List<Posture> postureList;
//
//    @Enumerated(EnumType.STRING)
//    private Role role; // USER, ADMIN
//
//    public Member(CreateMemberDto createMemberDto) {
//        this.loginId = createMemberDto.getLoginId();
//        this.username = createMemberDto.getUsername();
//        this.password = createMemberDto.getPassword();
//        this.sex = createMemberDto.getSex();
//        this.age = createMemberDto.getAge();
//        this.role = Role.USER;
//    }
//}
