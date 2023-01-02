package com.example.intern.web.dto.posture;

import com.example.intern.web.entity.BusinessMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
public class CreatePostureDto {

    @JsonIgnore
    private BusinessMember bm;

    @ApiModelProperty(value = "상부변위")
    private double td;              // 상부변위

    @ApiModelProperty(value = "하부변위")
    private double bd;              // 하부변위

    @ApiModelProperty(value = "상가압")
    private double tp;              // 상가압

    @ApiModelProperty(value = "하가압")
    private double bp;              // 하가압

    @ApiModelProperty(value = "양불")
    private Integer t_f;            // 양불

    private LocalTime createTime;
    private LocalDate createDate;

    @Builder
    public CreatePostureDto(LocalTime createTime, LocalDate createDate, BusinessMember bm, double td, double bd, double tp, double bp, Integer t_f) {
        this.bm = bm;
        this.createTime = createTime;
        this.createDate = createDate;
        this.td = Math.round(td * 10000) / 10000.0;
        this.bd = Math.round(bd * 10000) / 10000.0;
        this.tp = Math.round(tp * 10000) / 10000.0;
        this.bp = Math.round(bp * 10000) / 10000.0;
        this.t_f = t_f;
    }
}
