package com.example.work.commute;

import com.example.work.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommuteDto {

    private LocalDateTime working_Time;

    private LocalDateTime leave_working;

    private LocalDateTime rest_Time;

    private Member member;


    @Builder
    public CommuteDto(LocalDateTime working_Time, LocalDateTime leave_working, LocalDateTime rest_Time, Member member) {
        this.working_Time = working_Time;
        this.leave_working = leave_working;
        this.rest_Time = rest_Time;
        this.member =member;
    }
}
