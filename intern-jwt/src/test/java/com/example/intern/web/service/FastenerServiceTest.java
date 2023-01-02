package com.example.intern.web.service;

import com.example.intern.web.dto.fastener.CreateFastenerDto;
import com.example.intern.web.dto.bmember.CreateSign;
import com.example.intern.web.dto.posture.CreatePostureDto;
import com.example.intern.web.entity.BusinessMember;
import com.example.intern.web.entity.Fastener;
import com.example.intern.web.repository.BusinessMemberRepository;
import com.example.intern.web.repository.FastenerRepository;
import com.example.intern.web.service.businessmember.BusinessMemberService;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@WebAppConfiguration
@SpringBootTest
public class FastenerServiceTest {
    @Autowired
    FastenerService fastenerService;

    @Autowired
    FastenerRepository fastenerRepository;

    @Autowired
    BusinessMemberService businessMemberService;

    @Autowired
    BusinessMemberRepository businessMemberRepository;

    @Test
    @DisplayName("체결기 만들기")
    public void test() {
        Optional<BusinessMember> byId = businessMemberRepository.findById(2L);

        for (int i = 0; i < 40; i++) {
            CreateFastenerDto build = CreateFastenerDto.builder()
                    .bm(byId.get())
                    .tv(1.2462 + i)
                    .pv(2.3456 + i)
                    .fd(3.01246 + i)
                    .height(4.95483 + i)
                    .t_f(0)
                    .build();

            fastenerService.CreatFastener(build);
        }
    }
}
