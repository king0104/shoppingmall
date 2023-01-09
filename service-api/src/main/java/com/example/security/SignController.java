package com.example.security;

import com.example.ApiResponse;
import com.example.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignController {

    private final SignService signService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signin")
    public ApiResponse signin(@RequestParam String email, @RequestParam String password) {

        SigninDto signinDto = signService.signin(email, password);
        String token = jwtTokenProvider.createToken(String.valueOf(signinDto.getSellerNo()), signinDto.getRoles());

        return ApiResponse.builder()
                .success(true)
                .data(token)
                .build();


    }

//    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
//    @PostMapping(value = "/signup")
//    public CommonResult signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,
//                               @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
//                               @ApiParam(value = "이름", required = true) @RequestParam String name) {
//
//        userJpaRepo.save(User.builder()
//                .uid(id)
//                .password(passwordEncoder.encode(password))
//                .name(name)
//                .roles(Collections.singletonList("ROLE_USER"))
//                .build());
//        return responseService.getSuccessResult();
//    }
}