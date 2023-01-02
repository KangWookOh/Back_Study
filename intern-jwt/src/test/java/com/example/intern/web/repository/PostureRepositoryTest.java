package com.example.intern.web.repository;

import com.example.intern.web.dto.posture.CreatePostureDto;
import com.example.intern.web.entity.BusinessMember;
import com.example.intern.web.entity.Posture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class PostureRepositoryTest {

    @Autowired
    BusinessMemberRepository businessMemberRepository;

    @Autowired
    PostureRepository postureRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("쿼리 테스트")
    @Transactional
    void test() throws JsonProcessingException {
//        BusinessMember byB_number = businessMemberRepository.findByB_number(1234567);
//        Long key_id = byB_number.getKey_id();
//
//        Posture memberByPosture = postureRepository.findMemberByPosture(key_id);
//
//        byte[] bytes = objectMapper.writeValueAsBytes(memberByPosture);
//
//        System.out.println(bytes);
    }
}