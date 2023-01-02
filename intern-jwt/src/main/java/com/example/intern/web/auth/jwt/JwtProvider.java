package com.example.intern.web.auth.jwt;

import com.example.intern.web.service.businessmember.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtProvider {

    @Value("spring.jwt.secret")
    private String secretKey;

    // 토큰 만료 시간
    private Long tokenValidMillisecond = 60 * 60 * 1000L;

    private final CustomUserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // Jwt 생성
    public String createToken(String userLicense, List<String> roles) {
        // user 구분을 위해 Claims에 User Pk값 넣어줌
        Claims claims = Jwts.claims().setSubject(userLicense);
        claims.put("roles", roles);

        log.info("claims = {}", claims);

        // 생성날짜, 만료날짜를 위한 Date
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)      // 토큰 발급자
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Jwt 로 인증정보를 조회
    public Authentication getAuthentication (String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserLicense(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 클레임 정보
    // iss : 토큰 발급자
    // sub : 토큰 제목
    // aud : 토큰 대상자
    // exp : 토큰 만료 시간
    // iat : 토큰 발급 시간

    // jwt 에서 회원 구분 Pk 추출, 토큰을 가져와 디코딩
    public String getUserLicense(String token) {
        String substring = token.substring("Bearer ".length());
        log.info("넘어온 토큰 = {}", substring);

        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(substring).getBody();
        log.info("클레임 객체 정보 = {}", body);
        String license = String.valueOf(body.getSubject());
        return license;
    }

    // HTTP Request 의 Header 에서 Token Parsing -> "X-AUTH-TOKEN: jwt"
    // X-AUTH-TOKEN 에서, 헤더 정보 Authorization 로 변경
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    // jwt 의 유효성 및 만료일자 확인
    public boolean validationToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date()); // 만료날짜가 현재보다 이전이면 false
        } catch (Exception e) {
            return false;
        }
    }
}