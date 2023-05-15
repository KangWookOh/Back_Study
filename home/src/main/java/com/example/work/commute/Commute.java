package com.example.work.commute;

import com.example.work.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Commute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime workingTime;

    private LocalDateTime leaveWorking;

    private LocalDateTime restTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public Commute(LocalDateTime workingTime, LocalDateTime leaveWorking, LocalDateTime restTime, Member member) {
        this.workingTime = workingTime;
        this.leaveWorking = leaveWorking;
        this.restTime = restTime;
        this.member = member;
    }


}
