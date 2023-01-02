package com.example.intern.web.service.businessmember;

import com.example.intern.web.repository.BusinessMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final BusinessMemberRepository businessMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String userLicense) {
        return businessMemberRepository.findByLicense(userLicense);
    }
}