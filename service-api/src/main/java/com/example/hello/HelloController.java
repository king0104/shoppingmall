package com.example.hello;

import com.example.admin.Admin;
import com.example.admin.AdminRepository;
import com.example.security.JwtUtil;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final AdminRepository adminRepository;
    private final JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String findAdmin() {
        Optional<Admin> admin = adminRepository.findById(1L);
        System.out.println("admin = " + admin.toString());

        return admin.toString();
    }

    @GetMapping("/token-test")
    public void tokenTest(HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);

        Long sellerNo = Long.valueOf(jwtUtil.getUserPk(token));
        log.info("sellerNo = {}", sellerNo);

    }
}
