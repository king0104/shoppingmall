package com.example.store.store_registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegistrationUpdateRequest {
    @NotNull
    @Max(50)
    private String rejectType;

    @Max(1000)
    @NotNull
    private String rejectReason;

}
