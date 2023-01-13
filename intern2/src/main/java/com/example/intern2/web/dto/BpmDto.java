package com.example.intern2.web.dto;

import com.example.intern2.web.entity.Bpm;
import com.example.intern2.web.entity.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class BpmDto {

    @ApiModelProperty(value = "diastole")
    private Integer sys;
    @ApiModelProperty(value = "systolic")
    private Integer dia;
    @ApiModelProperty(value = "heart_rate")
    private Integer pulse;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Aisa/Seoul")
    private LocalDateTime dateTime;
    
    private long userId;
    private User user_id;





    @Builder
    public BpmDto(Integer sys ,Integer dia ,Integer pulse,User user_id,LocalDateTime dateTime)
    {
        this.sys =sys;
        this.dia=dia;
        this.pulse=pulse;
        this.user_id=user_id;
        this.dateTime=dateTime;

    }




}
