package com.example.work.member;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String m_Id;

    private String m_Name;

    @Builder
    public Member(String m_Id , String m_Name){
        this.m_Id= m_Id;
        this.m_Name = m_Name;
    }


}
