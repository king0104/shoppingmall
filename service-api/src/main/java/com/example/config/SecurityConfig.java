package com.example.config;

import com.example.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        http
                .httpBasic().disable() // rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
                .csrf().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt token으로 인증하므로 세션은 필요없으므로 생성안함.
                .and()
                    .authorizeRequests() // 다음 리퀘스트에 대한 사용권한 체크
                        .antMatchers("/signin", "/signup").permitAll() // 가입 및 인증 주소는 누구나 접근가능
                        .antMatchers(HttpMethod.GET, "hello/**").permitAll() // hellowworld로 시작하는 GET요청 리소스는 누구나 접근가능
                        .anyRequest().hasRole("USER") // 그외 나머지 요청은 모두 인증된 회원만 접근 가능
                .and()
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // jwt token 필터를 id/password 인증 필터 전에 넣는다

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

    @Bean // ignore check swagger resource
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/favicon.ico"
                ,"/error","/swagger-ui/**","/swagger-resources/**","/v3/api-docs/**","/swagger-config/**");
    }

}
