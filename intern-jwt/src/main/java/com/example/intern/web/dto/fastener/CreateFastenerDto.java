package com.example.intern.web.dto.fastener;

import com.example.intern.web.entity.BusinessMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class CreateFastenerDto {

    private LocalDate createDate;
    private LocalTime createTime;

    @ApiModelProperty(value = "원자재 높이")
    private double height;              // 원자재 높이

    @ApiModelProperty(value = "체결 편치")
    private double fd;                  // 체결 편차

    @ApiModelProperty(value = "압력")
    private double pv;                  // 압력

    @ApiModelProperty(value = "토크 값")
    private double tv;                  // 토크값

    @ApiModelProperty(value = "양불")
    private Integer t_f;                // 양

    @JsonIgnore
    private BusinessMember bm;

    @Builder
    public CreateFastenerDto(LocalDate createDate, LocalTime createTime, BusinessMember bm, double height, double fd, double pv, double tv, Integer t_f) {
        this.createDate = createDate;
        this.createTime = createTime;
        this.bm = bm;
        this.t_f = t_f;
        this.height = Math.round(height * 10000) / 10000.0;
        this.fd = Math.round(fd * 10000) / 10000.0;
        this.pv = Math.round(pv * 10000) / 10000.0;
        this.tv = Math.round(tv * 10000) / 10000.0;
    }
}
