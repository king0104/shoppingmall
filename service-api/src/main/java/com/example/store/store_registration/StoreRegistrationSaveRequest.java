package com.example.store.store_registration;

import com.example.validation.OpenCloseTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalTime;

@OpenCloseTime(
        openTime = "openTime",
        closeTime = "closeTime",
        message = "open시간이 close시간 이전이어야 합니다"
)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreRegistrationSaveRequest {

    private Long sellerNo;
    @Size(min = 0, max = 1000) // string min,max 정하기
    private String introduction;
    @Size(min = 0, max = 30)
    private String name;

    private LocalTime openTime; // 날짜 없는 시각은 localtime 사용 - jacksonConfig에서 validation
    private LocalTime closeTime;
    @Pattern(regexp = "^\\d{11}$", message = "숫자 11개로 입력해야합니다 (예시 - 01012345678)") // 11개 숫자만 오도록 정규식 작성
    private String phone;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    @Size(min = 0, max = 50)
    private String location;

}
