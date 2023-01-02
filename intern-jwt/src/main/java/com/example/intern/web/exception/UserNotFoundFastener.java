package com.example.intern.web.exception;

import lombok.Getter;

@Getter
public class UserNotFoundFastener extends RuntimeException {

    private static final String MESSAGE = "라이센스에 '20' 이 포함되어 있지 않습니다.";

    public UserNotFoundFastener() {
        super(MESSAGE);
    }
}
