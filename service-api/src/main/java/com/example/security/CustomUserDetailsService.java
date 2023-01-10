package com.example.security;

import com.example.seller.Seller;
import com.example.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SellerRepository sellerRepository;

    @Override
    public UserDetails loadUserByUsername(String sellerNo) throws UsernameNotFoundException {

        System.out.println("인증을 받습니다.");

        return sellerRepository.findById(Long.valueOf(sellerNo))
                .orElseThrow(() -> new UsernameNotFoundException("Not Registered seller. sellerNo : " + sellerNo));

    }

//    private Collection<GrantedAuthority> createAuthorities(Seller seller) {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_"+seller.getRole()));
//        return authorities;
//    }

}