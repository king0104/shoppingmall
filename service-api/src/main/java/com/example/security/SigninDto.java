package com.example.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class SigninDto {
    private Long sellerNo;
    private List<String> roles;

}
