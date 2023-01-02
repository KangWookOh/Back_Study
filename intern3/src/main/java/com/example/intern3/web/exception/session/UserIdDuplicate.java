package com.example.intern3.web.exception.session;

public class UserIdDuplicate extends RuntimeException{
    private static final String MESSAGE = "이미 사용중인 아이디 입니다.";
    public UserIdDuplicate(){
        super(MESSAGE);
    }

}
