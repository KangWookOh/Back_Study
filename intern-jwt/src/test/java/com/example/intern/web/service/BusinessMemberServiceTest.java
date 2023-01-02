package com.example.intern.web.service;

import com.example.intern.web.dto.bmember.CreateSign;
import com.example.intern.web.repository.BusinessMemberRepository;
import com.example.intern.web.service.businessmember.BusinessMemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;


@SpringBootTest
@Slf4j
class BusinessMemberServiceTest {

    @Autowired
    BusinessMemberRepository businessMemberRepository;

    @Autowired
    BusinessMemberService businessMemberService;

    //@BeforeEach
    void clear() {
        businessMemberRepository.deleteAll();
    }

    @Test
    @DisplayName("가입 서비스")
    void test() {
        CreateSign createSign = CreateSign.builder()
                .b_number(1234567)
                .license("hi1")
                .build();

        businessMemberService.signUp(createSign);

        CreateSign createSign2 = CreateSign.builder()
                .b_number(12345672)
                .license("hi2")
                .build();

        businessMemberService.signUp(createSign2);
    }

    @Test
    @DisplayName("signList 가져오기")
    void test1() throws Exception {
        CreateSign createSign = CreateSign.builder()
                .b_number(1234567)
                .license("i am license 224")
                .build();

        businessMemberService.signUp(createSign);

        CreateSign createSign2 = CreateSign.builder()
                .license("i am license 224")
                .b_number(1234567)
                .build();
    }

    @Test
    public void transt() {
        CreateSign createSign = CreateSign.builder()
                .b_number(123467123)
                .license("10-459232")
                .build();

        businessMemberService.signUp(createSign);
    }
}