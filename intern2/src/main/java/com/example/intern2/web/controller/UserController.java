package com.example.intern2.web.controller;

import com.example.intern2.web.auth.jwt.JwtProvider;
import com.example.intern2.web.dto.UserDto;
import com.example.intern2.web.entity.User;
import com.example.intern2.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.PanelUI;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
@ApiOperation(value = "value= 회원 가입 및 로그인 API",notes = "로그인시 JWT 토큰 발급")
@ApiResponses({ @ApiResponse(code = 200,message = "API 정상작동"),
        @ApiResponse(code = 500,message = "서버 에러")
})

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
    public ResponseEntity<?>login(@RequestBody UserDto userDto, HttpServletResponse response) throws Exception
    {
        userService.login(userDto.getUserId(),userDto.getUserPw());
        String token = jwtProvider.createToken(userDto.getUserId(),userDto.getRoles());
        response.setHeader("Authorization",token);
        return ResponseEntity.ok(token);

    }

}
