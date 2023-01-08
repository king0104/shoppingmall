package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        http
                .cors().and() //  CorsFilter 활성화
                .csrf().disable() // 세션을 사용하지 않고 JWT 토큰을 활용하여 진행하고 REST API를 만드는 작업이기때문에 csrf 사용은 disable 처리합니다.
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 현재 스프링 시큐리티에서 세션을 관리하지 않겠다는 뜻(클라이언트에서 요청하는 헤더에 token을 담아보내고, 서버에서 토큰을 확인하여 인증하는 방식을 사용할 것이기 때문)
                .and()
                .authorizeRequests() // [인증]
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //                    .antMatchers("/api/v1/test/permit-all").permitAll()
                //                    .antMatchers("/api/v1/test/auth").authenticated()
                .antMatchers("/**").authenticated() // 인증 완료되어야 해당 api 사용 가능. 미인증시 403 forbidden
                .anyRequest().permitAll()
                .and()
                .formLogin().disable()
        ;

        return http.build();
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CustomAuthenticationFilter customAuthenticationFilter(AuthenticationManager authManager) throws Exception {
//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authManager); // manager 호출하는 부분 애매(파라미터 저게 맞나?)
////        customAuthenticationFilter.setFilterProcessesUrl("/login"); // ? 이부분 뭔지 알기
//        customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler);
//        customAuthenticationFilter.setAuthenticationFailureHandler(customLoginFailureHandler);
//        customAuthenticationFilter.afterPropertiesSet();
//        return customAuthenticationFilter;
//    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }
}
