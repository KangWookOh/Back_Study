package com.example.intern.web.controller;

import com.example.intern.web.exception.ErrorResponse;
import com.example.intern.web.exception.UserNotFoundFastener;
import com.example.intern.web.exception.UserNotFoundPosture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(UserNotFoundPosture.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> UserNotFoundPosture(UserNotFoundPosture e) {
        ErrorResponse body = ErrorResponse.builder()
                .message(e.getMessage())
                .build();

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(UserNotFoundFastener.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> UserNotFoundFastener(UserNotFoundFastener e) {
        ErrorResponse body = ErrorResponse.builder()
                .message(e.getMessage())
                .build();

        return ResponseEntity.badRequest().body(body);
    }
}
