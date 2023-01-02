package com.example.intern3.web.service.User;

import com.example.intern3.web.dto.UserDto;
import com.example.intern3.web.entity.User;
import com.example.intern3.web.repository.UserRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    public Long signUp(UserDto userDto);
    public String  login(String userId,String userPw);

    public void checkUseridDuplicate(String userId);





}
