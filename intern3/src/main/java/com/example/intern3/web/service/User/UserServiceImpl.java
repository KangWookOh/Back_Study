package com.example.intern3.web.service.User;

import com.example.intern3.web.dto.UserDto;
import com.example.intern3.web.entity.User;
import com.example.intern3.web.exception.session.UserIdDuplicate;
import com.example.intern3.web.repository.UserRespository;
import com.example.intern3.web.service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public Long signUp(UserDto userDto) {
        checkUseridDuplicate(userDto.getUserId());
        Long id =userRespository.save(
                User.builder()
                        .userId(userDto.getUserId())
                        .userPw(passwordEncoder.encode(userDto.getUserPw()))
                        .userName(userDto.getUserName())
                        .build()).getId();
        return id;
    }

    @Override
    @Transactional
    public String login(String userId, String userPw) {
        Optional<User> user = userRespository.findByuserId(userId);
        if(user.isEmpty()){
            return null;
        }
        if(!passwordEncoder.matches(userPw,user.get().getUserPw()))
        {
            return user.get().getUserId();
        }else {
            return  null;
        }
    }

    @Override
    public void checkUseridDuplicate(String userid) {
        if(userRespository.findByuserId(userid).isPresent())
        {
            throw new UserIdDuplicate();
        }

    }
}
