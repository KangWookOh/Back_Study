package com.example.chang_intern1.web.service;

import com.example.chang_intern1.web.auth.jwt.JwtTokenProvider;
import com.example.chang_intern1.web.entity.User;
import com.example.chang_intern1.web.entity.dto.UserDto;
import com.example.chang_intern1.web.repository.UserRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BpUserService {
    private final UserRepositroy userRepositroy;

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signup(UserDto userDto)
    {
        User user = User.builder()
                .userId(userDto.getUserId())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .userName(userDto.getUserName())
                .userAge(userDto.getUserAge())
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
        return userRepositroy.save(user);
    }
//    @Transactional
//    public String login(BpUserDto)
//    {
//        BpUser user= bpUserRepositroy.findByUserId(bpUserDto.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지않은 아이디 입니다."));
//        if(!passwordEncoder.matches(bpUserDto.getUserPw(),user.getPassword()))
//        {
//            throw new IllegalArgumentException("비밀번호가 일치 하지 않습니다.");
//        }
//        return jwtTokenProvider.createToken(user.getUserId(),user.getRoles());
//    }
    @Transactional
    public User login(UserDto bpUserDtoDto)
    {
        User user =userRepositroy.findByUserId(bpUserDtoDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을수 없습니다")
        );
        if(!passwordEncoder.matches(bpUserDtoDto.getUserPw(),user.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치 하지 않습니다.");
        }
        return user;
    }


    @Transactional
    public List<User> getList()
    {
        return userRepositroy.findAll();
    }



}
