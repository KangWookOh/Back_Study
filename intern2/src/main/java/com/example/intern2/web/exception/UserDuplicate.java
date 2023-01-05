package com.example.intern2.web.exception;

public class UserDuplicate extends RuntimeException{
    private static final  String MESSAGE = "이미 사용중인 아이디 입니다.";

    public UserDuplicate(){
        super(MESSAGE);
    }
}
