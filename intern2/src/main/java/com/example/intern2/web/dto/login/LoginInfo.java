package com.example.intern2.web.dto.login;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class LoginInfo {

    private Long id;

    private String userId;

    private String userPw;

    public LoginInfo(Long id, String userId, String userPw)
    {
        this.id=id;
        this.userId=userId;
        this.userPw=userPw;
    }
}
