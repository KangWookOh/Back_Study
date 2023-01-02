package com.example.intern2.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Bpm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer sys;

    private Integer dia;

    private Integer pulse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User uid;



    @Builder
    public Bpm(Integer sys, Integer dia ,Integer pulse,User uid)
    {
        this.sys =sys;
        this.dia = dia;
        this.pulse = pulse;
        this.uid=uid;
    }

}
