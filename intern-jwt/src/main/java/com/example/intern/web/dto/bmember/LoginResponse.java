package com.example.intern.web.dto.bmember;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

    private LoginInfo loginInfo;
    private String token;
}
