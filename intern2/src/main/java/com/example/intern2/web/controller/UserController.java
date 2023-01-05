package com.example.intern2.web.controller;

import com.example.intern2.web.auth.jwt.JwtProvider;
import com.example.intern2.web.dto.UserDto;
import com.example.intern2.web.entity.User;
import com.example.intern2.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDto userDto) throws IOException
    {
        User user =userService.signup(userDto);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody UserDto userDto) throws Exception
    {
        userService.login(userDto.getUserId(),userDto.getUserPw());
        String token = jwtProvider.createToken(userDto.getUserId(),userDto.getRoles());
        return ResponseEntity.ok(token);

    }

}
