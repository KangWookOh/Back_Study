package com.example.intern2.web.dto.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private LoginInfo loginInfo;
    private String token;
}
