package com.example.intern3.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class LoginRequestDto {

    private String userId;

    private String userPw;
}
