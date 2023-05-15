package com.example.work.pause;

import com.example.work.member.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
public class Pause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime pause_Time;

    private LocalDateTime resume_Time;

    private Reason reason;

    @ManyToOne
    private Member member;

    @Builder
    public Pause(LocalDateTime pause_Time,LocalDateTime resume_Timem, Reason reason, Member member){
        this.pause_Time =pause_Time;
        this.resume_Time = resume_Timem;
        this.reason =reason;
        this.member = member;
    }


}
