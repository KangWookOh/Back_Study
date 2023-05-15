package com.example.work.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private String m_Id;

    private String m_Name;

    @Builder
    public MemberDto(String m_Id,String m_Name){
        this.m_Id = m_Id;
        this.m_Name = m_Name;
    }

}
