package com.example.chang_intern1.web.service;

import com.example.chang_intern1.web.repository.BpUserRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final BpUserRepositroy bpUserRepositroy;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return bpUserRepositroy.findByUserId(userId).orElseThrow(
                () ->new UsernameNotFoundException("사용자 정보를 찾을수 없습니다.")
        );
    }
}
