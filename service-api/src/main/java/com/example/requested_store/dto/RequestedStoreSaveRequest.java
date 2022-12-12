package com.example.requested_store.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// controller에서 사용하는 dto
@Getter
@NoArgsConstructor
public class RequestedStoreSaveRequest {

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

    @Builder
    public RequestedStoreSaveRequest(Long sellerNo, String introduction, String name, LocalTime openTime, LocalTime closeTime, String phone, String email, String location, String rejectType, String rejectReason) {
        this.sellerNo = sellerNo;
        this.introduction = introduction;
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.rejectType = rejectType;
        this.rejectReason = rejectReason;
    }
}
