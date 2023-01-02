package com.example.intern3.web.dto;

import com.example.intern3.web.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BpmDto {

    private  Integer dia;

    private Integer sys;

    private Integer pulse;

    private User user;


    @Builder
    public BpmDto(Integer dia,Integer sys,Integer pulse, User user)
    {
        this.dia =dia;
        this.sys=sys;
        this.pulse =pulse;
        this.user=user;
    }
}
