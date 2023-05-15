package com.example.work.pause;

import com.example.work.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PauseDto {

    private LocalDateTime pauseTime;

    private LocalDateTime resumeTime;

    private Reason reason;


    private Member member;

    @Builder
    public PauseDto(LocalDateTime pauseTime, LocalDateTime resumeTime, Reason reason, Member member) {
        this.pauseTime = pauseTime;
        this.resumeTime = resumeTime;
        this.reason = reason;
        this.member = member;
    }
}
