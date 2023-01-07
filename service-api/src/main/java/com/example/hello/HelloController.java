package com.example.hello;

import com.example.admin.Admin;
import com.example.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final AdminRepository adminRepository;

    @GetMapping("/hello")
    public String findAdmin() {
        Optional<Admin> admin = adminRepository.findById(1L);
        System.out.println("admin = " + admin.toString());

        return admin.toString();
    }
}
