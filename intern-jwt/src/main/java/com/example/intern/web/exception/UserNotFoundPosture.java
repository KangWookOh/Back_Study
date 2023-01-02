package com.example.intern.web.exception;

import lombok.Getter;

@Getter
public class UserNotFoundPosture extends RuntimeException {

    private static final String MESSAGE = "라이센스에 '10' 이 포함되어 있지 않습니다.";

    public UserNotFoundPosture() {
        super(MESSAGE);
    }
}
