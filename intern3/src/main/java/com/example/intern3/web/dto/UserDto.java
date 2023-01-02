package com.example.intern3.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String userId;

    private String userPw;

    private String userName;


    @Builder
    public UserDto(String userid ,String userpw,String username)
    {
        this.userId = userid;
        this.userPw =userpw;
        this.userName =username;
    }
}
