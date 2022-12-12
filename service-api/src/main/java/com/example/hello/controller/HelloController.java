package com.example.hello.controller;

import com.example.admin.entity.Admin;
import com.example.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final AdminRepository adminRepository;

    @GetMapping("/admin")
    public String findAdmin() {
        Optional<Admin> admin = adminRepository.findById(1L);
        System.out.println("admin = " + admin.toString());

        return admin.toString();
    }
}
