package com.example.chang_intern1.web.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String userId;

    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String userPw;
    private String userName;
    private String userAge;
    private List<String> roles = new ArrayList<>();

    @Builder
    private UserDto(String userId, String userPw, String userName, String userAge, String userGender, List<String> roles) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userAge = userAge;
        this.roles = roles;
    }

//    public BpUser toEntity() {
//        return BpUser.builder()
//                .userId(userId)
//                .userPw(userPw)
//                .userName(userName)
//                .userAge(userAge)
//                .build();
//
//
//    }
}



