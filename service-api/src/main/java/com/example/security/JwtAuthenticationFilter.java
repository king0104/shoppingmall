package com.example.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// import 생략

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtUtil jwtUtil;

    // Request로 들어오는 Jwt Token의 유효성을 검증(jwtTokenProvider.validateToken)하는 filter를 filterChain에 등록합니다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException, ServletException, IOException {
        String token = jwtUtil.resolveToken((HttpServletRequest) request);
        if (token != null && jwtUtil.validateToken(token)) {
            // < 들어온 토큰이 유효하면, 아래 로직 수행 >
            // 1. authentication 객체(토큰) 얻어옴
            Authentication auth = jwtUtil.getAuthentication(token);
            // 2. authentication 객체 저장하기
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}