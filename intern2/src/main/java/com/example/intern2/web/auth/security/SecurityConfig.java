package com.example.intern2.web.auth.security;

import com.example.intern2.web.auth.jwt.JwtAuthenticationFilter;
import com.example.intern2.web.auth.jwt.JwtProvider;
import com.example.intern2.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 인증을 무시하기 위한 설정
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/lib/**, /swagger-ui/**," +
                "/swagger-ui.html, /swagger-resources/**, /swagger-ui/**");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception{
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()  // 비 인증시 로그인화면으로 리다이렉트 하는걸 비활성화, api 이기 때문
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()      // 아무나 접근 가능한 리소스
                .anyRequest().hasRole("USER")                   // 그외는 ROLE_USER 권한이 필요함 명시
                .and()

                // jwt 인증 필터를 UsernamePasswordAuthenticationFilter 전에 사용
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

    }
}
