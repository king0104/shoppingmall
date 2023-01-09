package com.example.seller;

import com.example.common.ErrorCode;
import com.example.exception.NotFoundSellerException;
import com.example.security.JwtTokenProvider;
import com.example.seller.SellerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;


}
