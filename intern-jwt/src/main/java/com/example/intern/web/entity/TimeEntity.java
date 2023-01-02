package com.example.intern.web.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity {

    @Column(name = "date")
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate;

    @Column(name = "time")
    @CreatedDate
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime createTime;
}


