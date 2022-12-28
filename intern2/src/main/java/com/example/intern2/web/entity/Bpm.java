package com.example.intern2.web.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Bpm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer sys;

    private Integer dia;

    private Integer pulse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user",nullable = false)
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
