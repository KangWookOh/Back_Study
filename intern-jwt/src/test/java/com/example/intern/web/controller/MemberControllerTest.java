package com.example.intern.web.controller;

import com.example.intern.web.repository.BusinessMemberRepository;
import com.example.intern.web.service.businessmember.BusinessMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BusinessMemberRepository businessMemberRepository;

    @Autowired
    BusinessMemberService businessMemberService;

//    @Test
//    @DisplayName("session test")
//    void session() throws Exception {
//        // given
//        CreateSign createSign = CreateSign.builder()
//                .b_number(1234567)
//                .license("i am license 224")
//                .build();
//
//        businessMemberService.signUp(createSign);
//
//        // when
//        CreateSign createSign2 = CreateSign.builder()
//                .license("i am license 224")
//                .b_number(1234567)
//                .build();
//
//        LoginInfo loginInfo = businessMemberService.loginInfo(createSign2);
//        MockHttpSession session = new MockHttpSession();
//        session.setAttribute("loginV1", loginInfo);
//
//        MockHttpServletRequest req = new MockHttpServletRequest();
//        req.setSession(session);
//
//        // expected
//        mockMvc.perform(MockMvcRequestBuilders.post("/login/test").session(session))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
}