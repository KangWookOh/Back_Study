package com.example.chang_intern1.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.swing.plaf.PanelUI;
import java.time.LocalDateTime;
@Getter
@Entity
@NoArgsConstructor
public class Bpm {

    private String SYS;

    private String DIA;

    private String PULSE;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime Day;

    @Builder
    public Bpm(String sys,String dia ,String pulse)
    {
        this.SYS =sys;
        this.DIA = dia;
        this.PULSE =pulse;
    }
}
