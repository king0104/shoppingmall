package com.example.store.store_registration;

import com.example.seller.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegistrationResponse {
    private Long storeRegistrationNo;
    private Seller seller;
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
