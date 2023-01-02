package com.example.intern3.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Bpm {
    @Id @GeneratedValue
    private Long id;

    private Integer dia;

    private Integer sys;

    private Integer pulse;
    @Timestamp
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Bpm(Integer sys, Integer dia ,Integer pulse,User user)
    {
        this.sys =sys;
        this.dia = dia;
        this.pulse = pulse;
        this.user=user;
    }
}
