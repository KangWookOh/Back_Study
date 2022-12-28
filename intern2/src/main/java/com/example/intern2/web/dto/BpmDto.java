package com.example.intern2.web.dto;

import com.example.intern2.web.entity.Bpm;
import com.example.intern2.web.entity.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class BpmDto {

    private Integer sys;

    private Integer dia;

    private Integer pulse;

    private User user;



    @Builder
    public BpmDto(Integer sys ,Integer dia ,Integer pulse,User user)
    {
        this.sys =sys;
        this.dia=dia;
        this.pulse=pulse;
        this.user=user;

    }


}
