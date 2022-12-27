package com.example.chang_intern1.web.controller;

import com.example.chang_intern1.web.auth.jwt.JwtTokenProvider;
import com.example.chang_intern1.web.entity.BpUser;
import com.example.chang_intern1.web.entity.User;
import com.example.chang_intern1.web.entity.dto.UserDto;
import com.example.chang_intern1.web.repository.BpUserRepositroy;
import com.example.chang_intern1.web.repository.UserRepositroy;
import com.example.chang_intern1.web.service.BpUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BpUserController {

    private final UserRepositroy bpUserRepositroy;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    åprivate final BpUserService bpUserService;



    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDto userDto)
    {
        User bp = bpUserService.signup(userDto);
        return ResponseEntity.ok().body(bp);
    }




    @PostMapping("/login")
    public String login(@RequestBody UserDto bpUserDtoDto)
    {
        User user = bpUserRepositroy.findByUserId(bpUserDtoDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 아이디 입니다."));
        if(!passwordEncoder.matches(bpUserDtoDto.getUserPw(),user.getUserPw())){
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }
        return jwtTokenProvider.createToken(user.getUserId(),user.getRoles());
    }


//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody BpUserDto bpUserDto)
//    {
//        BpUser user =bpUserService.login(bpUserDto);
//        return ResponseEntity.ok().body(jwtTokenProvider.createToken(user.getUserId(), user.getRoles()));
//    }



    @GetMapping("/userList")
    public ResponseEntity userList()
    {
        return ResponseEntity.ok().body(bpUserService.getList());
    }


//    @AllArgsConstructor
//    @Data
//    static class LoginSuccessResponse {
//        private String token;
//    }
//
//    @AllArgsConstructor
//    @Data
//    static class LoginRequest{
//        private String userId;
//        private String userPw;
//    }

}
