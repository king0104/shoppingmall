package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ServiceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApiApplication.class, args);
    }
}