package com.example.chang_intern1.web.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BpmDto {

    private String SYS;

    private String DIA;

    private String PULSE;

    @Builder
    public BpmDto(String sys,String dia ,String pulse)
    {
        this.SYS =sys;
        this.DIA = dia;
        this.PULSE =pulse;
    }
}
