package com.example.chang_intern1;

import com.example.chang_intern1.web.controller.BpInfoController;
import com.example.chang_intern1.web.entity.BpInfo;
import com.example.chang_intern1.web.entity.BpUser;
import com.example.chang_intern1.web.entity.dto.BpInfoDto;
import com.example.chang_intern1.web.entity.enums.Type;
import com.example.chang_intern1.web.repository.BpInfoRepositroy;
import com.example.chang_intern1.web.repository.BpUserRepositroy;
import com.example.chang_intern1.web.service.BpInfoService;
import com.example.chang_intern1.web.service.BpUserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)
public class BpInfoTest {
    private static final String user = "kang";
    @Autowired
    BpInfoService bpInfoService;
    @Autowired
    BpInfoRepositroy bpInfoRepositroy;

    @Autowired
    BpUserService bpUserService;

    @Autowired
    BpUserRepositroy bpUserRepositroy;

    private MockMvc mockMvc;

    @Test
    void test()
    {
         Long max_bp = 102L;
         Long min_bp = 10L;
         Type type = Type.valueOf("RELAX");
         String user = "kang";

         bpInfoRepositroy.findUserByBpInfo(user);

         List<BpInfo> list = bpInfoRepositroy.findAll();

         BpInfo bpInfo = list.get(0);

   }
}
