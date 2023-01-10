package com.example.store.store_registration;

import com.example.ApiResponse;
import com.example.common.HttpStatusCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class StoreRegistrationController {

    private final StoreRegistrationService storeRegistrationService;

    // 1. 토큰을 받는다
    // 2. 토큰에서 sellerNo 추출한다
    // 3. 그걸로 request만든다
    @PostMapping("/store/store-registration")
    public ApiResponse register(@Validated @RequestBody StoreRegistrationSaveRequest request) {

        storeRegistrationService.save(StoreRegistrationMapper.INSTANCE.toStoreRegistrationSaveDto(request));

        return ApiResponse.builder()
                .success(true)
                .data(HttpStatusCode.CREATED.getDescription())
                .build();

    }

/**
 * // storeRequest body
 * {
 *     "introduction": "string",
 *     "name": "string",
 *     "openTime": "00:00:00",
 *     "closeTime": "11:11:11",
 *     "phone": "08133268790",
 *     "email": "4545abc@naver.com",
 *     "location": "string"
 * }
 */

}
