package com.example.work;

import com.example.work.commute.Commute;
import com.example.work.commute.CommuteRepository;
import com.example.work.member.Member;
import com.example.work.member.MemberRepository;
import com.example.work.pause.PauseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class MemberTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PauseRepository pauseRepository;
    @Autowired
    CommuteRepository commuteRepository;




    @Test
    void test() {
        //insert
        Member save = memberRepository.save(
                Member.builder()
                        .m_Id("kang")
                        .m_Name("kang")
                        .build()

        );


    }
    @Test
    void test1(){
        Optional<Member> findMember = memberRepository.findById(1L);
        if (findMember.isPresent()) {
            Commute save  = commuteRepository.save(
                    Commute.builder()
                            .restTime(null)
                            .workingTime(LocalDateTime.now()) //출근시간타임
                            .leaveWorking(LocalDateTime.now().plusHours(1l))
                            .member(findMember.get())
                            .build()
            );

        }

//         Member member = memberRepository.findById(1L).get(); //방법1

    }
    @Test
    void test2(){
        Commute commute = commuteRepository.findById(1L).get();
        System.out.println("commute = " + commute.getMember());
    }
}
