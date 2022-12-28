package com.example.intern2.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPw;

    private String userName;
    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<String> roles =new ArrayList<>();

    @Builder
    public User(String  userId, String userPw,String userName,List<String> roles)
    {
        this.userId =userId;
        this.userPw =userPw;
        this.userName =userName;
    }
    @Builder
    public User(Long id,String  userId, String userPw,String userName)
    {
        this.id =id;
        this.userId =userId;
        this.userPw =userPw;
        this.userName =userName;
    }
    @Builder
    public User(Long id,String  userId, String userPw,String userName,List<String> roles)
    {
        this.id =id;
        this.userId =userId;
        this.userPw =userPw;
        this.userName =userName;
    }
    public boolean matchUserPw(String userPw)
    {
        return this.userPw.equals(userPw);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.userPw;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
