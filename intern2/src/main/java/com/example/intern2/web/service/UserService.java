package com.example.intern2.web.service;

import com.example.intern2.web.dto.UserDto;
import com.example.intern2.web.dto.login.LoginInfo;
import com.example.intern2.web.entity.User;
import com.example.intern2.web.exception.UserDuplicate;
import com.example.intern2.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public User signup(UserDto userDto)
    {
        checkUser(userDto.getUserId());
        User user = User.builder()
                .userId(userDto.getUserId())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .userName(userDto.getUserName())
                .build();
        return userRepository.save(user);
    }

    @Transactional
    public String login(String userId ,String userPw)
    {
      User user= userRepository.findByUserId(userId).orElseThrow(
              () -> new IllegalArgumentException("아이디가 일치 하지 않습니다."));
      if(!passwordEncoder.matches(userPw,user.getPassword())){
          throw new IllegalArgumentException("비밀번호가 일치 하지 않습니다.");
      }

        return userId;
    }
    public List<User> getAllList()
    {
        return userRepository.findAll();
    }

    public void checkUser(String userId)
    {
        if(userRepository.findByUserId(userId).isPresent())
        {
            throw new UserDuplicate();
        }
    }




}
