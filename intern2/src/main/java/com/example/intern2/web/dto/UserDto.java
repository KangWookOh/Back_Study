package com.example.intern2.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String userId;
    private String userPw;
    private String userName;
    private List<String> roles =new ArrayList<>();

    @Builder
    public UserDto(String userId,String userPw,String userName)
    {
        this.userId = userId;
        this.userPw = userPw;
        this.userName =userName;
        roles.add("ROLE_USER");
    }

}
