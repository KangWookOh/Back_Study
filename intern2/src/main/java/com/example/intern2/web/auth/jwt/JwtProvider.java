package com.example.intern2.web.auth.jwt;

import com.example.intern2.web.service.CustomUserDetailsService;
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
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtProvider {
    @Value("internProject")
    private String secretKey;

    private Long tokenValidMillisecond = 600 * 600 * 1000L;

    private long ACCESS_TOKEN_VALIDATiON_SECOND = 60 * 30;


    private final CustomUserDetailsService userDetailsService;

    @PostConstruct
    protected void init()
    {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //JWT TOKEN 생성
    public String createToken(String userId, List<String> roles)
    {
        //user 구분을 위해 claims에 PK값을 넣어준다
        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("roles",roles);
        log.info("claims={}",claims);

        Date now =new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    public Long getValidationAccessTokenTime(){
        return ACCESS_TOKEN_VALIDATiON_SECOND;
    }



    // Jwt 로 인증정보를 조회
    public Authentication getAuthentication(String token)
    {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }
    // 클레임 정보
    // iss : 토큰 발급자
    // sub : 토큰 제목
    // aud : 토큰 대상자
    // exp : 토큰 만료 시간
    // iat : 토큰 발급 시간

    // jwt 에서 회원 구분 Pk 추출, 토큰을 가져와 디코딩
    public String getUserId(String token)
    {

        String substring =token.substring("Bearer".length());
        log.info("넘어온 토큰 = {}", substring);
        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(substring).getBody();
        String userId = String.valueOf(body.getSubject());
        return userId;





        //return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody().getSubject();

//        Claims body = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
//        log.info("클레임 객체 정보 = {}",body);
//        String userId = String.valueOf(body.getSubject());
//        return userId;
    }
    // HTTP Request 의 Header 에서 Token Parsing -> "X-AUTH-TOKEN: jwt"
    // X-AUTH-TOKEN 에서, 헤더 정보 Authorization 로 변경
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
    //jwt 유효성 및 만료일자 확인
    // jwt 의 유효성 및 만료일자 확인
    public boolean validationToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date()); // 만료날짜가 현재보다 이전이면 false
        } catch (Exception e) {
            return false;
        }
    }





}
