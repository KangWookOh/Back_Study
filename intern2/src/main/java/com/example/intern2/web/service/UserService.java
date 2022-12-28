package com.example.intern2.web.service;

import com.example.intern2.web.dto.UserDto;
import com.example.intern2.web.dto.login.LoginInfo;
import com.example.intern2.web.entity.User;
import com.example.intern2.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User signup(UserDto userDto)
    {
        User user = User.builder()
                .userId(userDto.getUserId())
                .userPw(userDto.getUserPw())
                .userName(userDto.getUserName())
                .build();
        return userRepository.save(user);
    }
    @Transactional
    public LoginInfo loginInfo(UserDto userDto)
    {
        User checkUser = userRepository.findByUserId(userDto.getUserId());
        if(!String.valueOf(userDto.getUserId()).equals(String.valueOf(checkUser.getUserId()))){
            log.info("아이디 확인 불가");
            throw new IllegalStateException("아이디 틀림");
        }
        if(!checkUser.matchUserPw(userDto.getUserPw()))
        {
            log.info("비밀번호 틀릴시 진입");
            throw  new IllegalStateException("비밀번호 오류");
        }
        return new LoginInfo(checkUser.getId(),checkUser.getUserId(),checkUser.getUserPw());


    }
    public List<User> getAllList()
    {
        return userRepository.findAll();
    }




}
