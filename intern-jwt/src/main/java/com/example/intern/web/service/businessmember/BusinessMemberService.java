package com.example.intern.web.service.businessmember;

import com.example.intern.web.dto.bmember.CreateSign;
import com.example.intern.web.dto.bmember.LoginInfo;
import com.example.intern.web.entity.BusinessMember;
import com.example.intern.web.repository.BusinessMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusinessMemberService {

    private final BusinessMemberRepository businessMemberRepository;

    @Transactional
    public BusinessMember signUp(CreateSign createSign) {
        validation(createSign);
        BusinessMember businessMember = BusinessMember.builder()
                .key_id(createSign.getKey_id())
                .b_number(createSign.getB_number())
                .license(createSign.getLicense())
                .roles(createSign.getRoles())
                .build();

        return businessMemberRepository.save(businessMember);
    }

    // 로그인
    @Transactional
    public LoginInfo loginInfo(CreateSign createSign) {
        BusinessMember checkB_number = businessMemberRepository.findByB_number(createSign.getB_number());

        if (!String.valueOf(createSign.getB_number()).equals(String.valueOf(checkB_number.getB_number()))) {
            log.info("사업자번호 == null 진입");
            throw new IllegalStateException("사업자 번호 틀림");
        }

        if (!checkB_number.matchLicense(createSign.getLicense())) {
            log.info("license 틀리면 진입");
            throw new IllegalStateException("license 틀림");
        }

        return new LoginInfo(checkB_number.getKey_id(), checkB_number.getB_number(), checkB_number.getLicense());
//        // 로그인 성공처리
//        // 세션에 회원 정보 보관
//        session.setAttribute("logInfo", loginInfo);
//        Cookie cookie = new Cookie("b_number", String.valueOf(loginInfo.getB_number()));
//        rep.addCookie(cookie);
    }

    public List<BusinessMember> getList(){
             return businessMemberRepository.findAll();
    }

    private void validation(CreateSign createSign) {
        Optional<BusinessMember> byLicense = businessMemberRepository.findByLicense1(createSign.getLicense());
        Optional<BusinessMember> byB_number = businessMemberRepository.findByB_number1(createSign.getB_number());

        if (byB_number.isPresent() || byLicense.isPresent()) {
            throw new IllegalArgumentException("이미 사용중인 기기번호 또는 이미 사용중인 라이센스 번호 입니다.");
        }
    }
}


/**
 *  scheduler test
 */

//@GetMapping("/test")
//public ResponseEntity testScheduled() {
//    List<BusinessMember> body = businessMemberService.scheduled();
//
//    return ResponseEntity.ok(body);
//}

//@Scheduled(fixedDelay = 4000)
//public List<BusinessMember> scheduled() {
//    List<BusinessMember> all = businessMemberRepository.findAll();
//    System.out.println(all);
//
//    return all;
//}
