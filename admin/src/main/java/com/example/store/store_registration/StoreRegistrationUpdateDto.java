package com.example.store.store_registration;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreRegistrationUpdateDto {
    private String rejectType;
    private String rejectReason;

    @Builder
    public StoreRegistrationUpdateDto(String rejectType, String rejectReason) {
        this.rejectType = rejectType;
        this.rejectReason = rejectReason;
    }
}
