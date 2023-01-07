package com.example.store.store_registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// service에서 사용하는 dto
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreRegistrationSaveDto {
    private Long sellerNo;
    private String introduction;
    private String name;
    private LocalTime openTime; // 날짜 없는 시각은 localtime 사용
    private LocalTime closeTime;
    private String phone;
    private String email;
    private String location;
}
