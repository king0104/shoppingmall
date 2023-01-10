package com.example.security;

import com.example.common.ErrorCode;
import com.example.exception.NotFoundSellerException;
import com.example.seller.Seller;
import com.example.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * rest api login은, 여기서 이루어지는게 전부다.
 * - 들어온 password와, db에서 가져온 password를 비교해서, 토큰 넘겨줄지 안넘겨줄지 정하는 것!!
 */
@RequiredArgsConstructor
@Service
public class SignService {

    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    public SigninDto signin(String email, String password) {
        Seller seller = sellerRepository.findSellerByEmail(email)
                .orElseThrow(() -> new NotFoundSellerException("해당 email과 일치하는 seller가 없습니다. email : " + email, ErrorCode.SELLER_NOT_FOUND));

        if (!passwordEncoder.matches(password, seller.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return SigninDto.builder()
                .sellerNo(seller.getSellerNo())
                .roles(seller.getRoles())
                .build();
        // 여기서 dto리턴하고, 컨트롤러에서 토큰 만들어서 리턴 getsingleresult??

    }
}
