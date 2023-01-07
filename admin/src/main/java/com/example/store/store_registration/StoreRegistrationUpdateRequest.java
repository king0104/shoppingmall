package com.example.store.store_registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegistrationUpdateRequest {
    @NotNull
    private String rejectType;
    @NotNull
    private String rejectReason;

}
