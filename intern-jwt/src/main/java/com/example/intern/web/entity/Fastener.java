package com.example.intern.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;

// 체결기
@Entity
@Getter
@Table(name = "fastener")
@NoArgsConstructor
public class Fastener extends TimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "원자재 높이")
    @Column(name = "materials_height")
    private double height;              // 원자재 높이

    @ApiModelProperty(value = "체결 편차")
    @Column(name = "fasten_deviation")
    private double fd;                  // 체결 변차

    @ApiModelProperty(value = "압력")
    @Column(name = "pressure_value")
    private double pv;                  // 압력

    @ApiModelProperty(value = "토크 값")
    @Column(name = "torque_val")
    private double tv;                  // 토크값

    @ApiModelProperty(value = "양불")
    private Integer t_f;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id")
    @JsonIgnore
    private BusinessMember businessMember;

    @Builder
    public Fastener(double height, double fd, double pv, double tv, Integer t_f,BusinessMember bm) {
        this.height = height;
        this.fd = fd;
        this.pv = pv;
        this.tv = tv;
        this.t_f = t_f;
        this.businessMember=bm;
    }
}
