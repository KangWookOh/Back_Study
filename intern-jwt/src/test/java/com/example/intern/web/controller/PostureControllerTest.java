///*
//package com.example.intern.web.controller;
//
//import com.example.intern.web.dto.posture.CreatePostureDto;
//import com.example.intern.web.entity.Posture;
//import com.example.intern.web.service.PostureService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import javax.persistence.Column;
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ContextConfiguration
//class PostureControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private PostureService postureService;
//
////    @Test
////    void test() throws Exception {
////
////        CreatePostureDto createPostureDto = CreatePostureDto.builder()
////                .bd(BigDecimal.valueOf(3.141592)).build();
////
////
////        Posture posture = Posture.builder()
////                .bd(createPostureDto.getBd())
////                .build();
////
////        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(objectMapper.writeValueAsString(posture)))
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.jsonPath("$.posture.bd").value(3.141592))
////                .andDo(MockMvcResultHandlers.print());
////
////    }
//}
//*/
