package com.example.store.store_registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

// entity랑 구별하기 위해 dto 접미사 붙임
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegistrationDto {
    private Long storeRegistrationNo;
    private Long sellerNo;
    private String introduction;
    private String name;
    private LocalTime openTime; // 날짜 없는 시각은 localtime 사용
    private LocalTime closeTime;
    private String phone;
    private String email;
    private String location;
    private String rejectType;
    private String rejectReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String isDeleted;

}