package com.example.intern2;

import com.example.intern2.web.dto.BpmDto;
import com.example.intern2.web.entity.User;
import com.example.intern2.web.repository.BpmRepository;
import com.example.intern2.web.repository.UserRepository;
import com.example.intern2.web.service.BpmService;
import com.example.intern2.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@WebAppConfiguration
@SpringBootTest
public class BpmTest {
    @Autowired
    BpmService bpmService;

    @Autowired
    BpmRepository bpmRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void test()
    {
        Optional<User> byId  = userRepository.findById(1L);


        for(int i=0; i<20; i++)
        {
            BpmDto build = BpmDto.builder()
                    .dia(120+i)
                    .sys(80+i)
                    .pulse(100+i)
                    .uid(byId.stream().findAny().get())
                    .build();
            bpmService.input(build);
        }

    }
}
