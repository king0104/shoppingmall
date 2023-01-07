package com.example.store.store_registration;

import com.example.ApiResponse;
import com.example.common.ErrorCode;
import com.example.common.HttpStatusCode;
import com.example.exception.ValidationException;
import com.example.validation.IsDeletedConstraint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
public class StoreRegistrationController {

    private final StoreRegistrationService storeRegistrationService;
    // <조회 api>
    @GetMapping("/store-registrations")
    public List<StoreRegistrationResponse> getStoreRegistrations(@Min(0) @RequestParam("offset")  Integer offset,
                                                            @Min(1) @RequestParam("size")  Integer size,
                                                            @RequestParam("firstTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  LocalDateTime firstTime, // 쿼리스트링 값에 대해서는 json deserializer 작동 안함 -> @DateTimeFormat 붙이기
                                                            @RequestParam("lastTime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  LocalDateTime lastTime,
                                                            @IsDeletedConstraint @RequestParam  (value = "isDeleted",required = false) String isDeleted) {
        isFirstLastTimeValidated(firstTime,lastTime);

        return storeRegistrationService.getRequestedStoreList(offset, size, firstTime, lastTime,isDeleted)
                .stream()
                .map(storeRegistrationDto -> StoreRegistrationMapper.INSTANCE.toResponse(storeRegistrationDto))
                .collect(Collectors.toList());
    }

    private void isFirstLastTimeValidated(LocalDateTime firstTime, LocalDateTime lastTime) {
        if (firstTime.isAfter(lastTime)) {
            log.error("firstTime : {}, lastTime : {} / 처음 날짜가 마지막 날짜보다 이전이어야 합니다", firstTime, lastTime);
            throw new ValidationException("처음 날짜가 마지막 날짜보다 이전이어야 합니다",ErrorCode.INVALID_INPUT_VALUE);
        }

        if (ChronoUnit.MONTHS.between(firstTime, lastTime) > 6) {
            log.error("firstTime : {}, lastTime : {} / 날짜 범위는 최대 6개월입니다.", firstTime, lastTime);
            throw new ValidationException("날짜 범위는 최대 6개월입니다.",ErrorCode.INVALID_INPUT_VALUE);
        }
    }

    // <승인, 거절 api>
    // 1. 승인
    @PutMapping("/store-requests/{storeRegistrationNo}/approve")
    public ApiResponse approveStoreRequest(@PathVariable("storeRegistrationNo") @NotNull @Min(0) Long storeRegistrationNo) {
        storeRegistrationService.approveRequestedStore(storeRegistrationNo);

        return ApiResponse.builder()
                .success(true)
                .data(HttpStatusCode.CREATED.getDescription())
                .build();
    }

    // 2. 거절
    @PutMapping("/store-requests/{storeRegistrationNo}/reject")
    public ApiResponse rejectStoreRequest(@PathVariable("storeRegistrationNo") @NotNull @Min(0) Long storeRegistrationNo, @RequestBody StoreRegistrationUpdateRequest request) {

        storeRegistrationService.rejectRequestedStore(storeRegistrationNo, StoreRegistrationMapper.INSTANCE.toUpdateDto(request));

        return ApiResponse.builder()
                .success(true)
                .data(HttpStatusCode.CREATED.getDescription())
                .build();
    }

}
