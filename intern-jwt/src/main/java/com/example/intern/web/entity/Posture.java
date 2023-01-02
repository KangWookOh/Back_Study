package com.example.intern.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//자세차
@Entity
@Getter
@Table(name = "posture")
@NoArgsConstructor
public class Posture extends TimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "상부변위")
    @Column(name = "top_displacement")
    private double td;                  // 상부 변위

    @ApiModelProperty(value = "하부변위")
    @Column(name = "bottom_displacement")
    private double bd;                 // 하부 변위

    @ApiModelProperty(value = "상가압")
    @Column(name = "top_pressure")
    private double tp;                  // 상가압

    @ApiModelProperty(value = "하가압")
    @Column(name = "bottom_pressure")
    private double bp;                  // 하가압

    @ApiModelProperty(value = "양불")
    private Integer t_f;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id")
    @JsonIgnore
    private BusinessMember businessMember;

    @Builder
    public Posture(BusinessMember bm, double td, double bd, double tp, double bp, Integer t_f) {
        this.businessMember = bm;
        this.td = td;
        this.bd = bd;
        this.tp = tp;
        this.bp = bp;
        this.t_f = t_f;
    }
}
