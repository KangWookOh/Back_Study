package com.example.intern2.web.dto;

import com.example.intern2.web.entity.Bpm;
import com.example.intern2.web.entity.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class BpmDto {

    private Integer sys;

    private Integer dia;

    private Integer pulse;

    private long user_id;
    private User uid;





    @Builder
    public BpmDto(Integer sys ,Integer dia ,Integer pulse,User uid)
    {
        this.sys =sys;
        this.dia=dia;
        this.pulse=pulse;
        this.uid=uid;

    }




}
