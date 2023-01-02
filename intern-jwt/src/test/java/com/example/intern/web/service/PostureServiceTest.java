package com.example.intern.web.service;

import com.example.intern.web.dto.posture.CreatePostureDto;
import com.example.intern.web.entity.BusinessMember;
import com.example.intern.web.repository.BusinessMemberRepository;
import com.example.intern.web.repository.PostureRepository;
import com.example.intern.web.service.businessmember.BusinessMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest
@Rollback(value = false)
@WebAppConfiguration
class PostureServiceTest {

    @Autowired
    PostureRepository postureRepository;

    @Autowired
    PostureService postureService;

    @Autowired
    BusinessMemberService businessMemberService;

    @Autowired
    BusinessMemberRepository businessMemberRepository;

    @Test
    @DisplayName("posture 한개 생성")
    void test() {
            CreatePostureDto postureDto = CreatePostureDto.builder()
                    .bd(3.1410)
                    .bp(3.2415)
                    .td(4.1234)
                    .tp(953.41242141412)
                    .t_f(2)
                    .build();

            postureService.createPosture(postureDto);
    }

    @Test
    @DisplayName("posture 여러개생성")
    @Transactional
    void test1() {
        Optional<BusinessMember> byId = businessMemberRepository.findById(3L);

        for (int i = 0; i < 1; i++) {
            CreatePostureDto postureDto = CreatePostureDto.builder()
                    .bm(byId.get())
                    .bd(3123.321 + i)
                    .bp(213.42 + i)
                    .td(5454.44+ i)
                    .tp(922 + i)
                    .t_f(2)
                    .build();

            postureService.createPosture(postureDto);
        }
    }
}