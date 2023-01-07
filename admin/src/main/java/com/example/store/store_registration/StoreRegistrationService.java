package com.example.store.store_registration;

import com.example.common.ErrorCode;
import com.example.exception.NotFoundStoreException;
import com.example.exception.NotFoundStoreRegistrationException;
import com.example.store.Store;
import com.example.store.StoreMapper;
import com.example.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StoreRegistrationService {

    private final StoreRegistrationRepository storeRegistrationRepository;
    private final StoreRepository storeRepository;

    private static final String DELETED = "Y";
    private static final String REJECTED = "REJECTED";
    private static final String APPROVED = "APPROVED";

    @Transactional
    public List<StoreRegistrationDto> getRequestedStoreList(Integer offset, Integer limit, LocalDateTime firstTime, LocalDateTime lastTime, String isDeleted) {
        // RequestedStore -> dto 변환
        return storeRegistrationRepository.findAll(offset,limit,firstTime,lastTime,isDeleted)
                .stream()
                .map(storeRequest -> StoreRegistrationMapper.INSTANCE.toDto(storeRequest))
                .collect(Collectors.toList());
    }

    // 1. 승인
    @Transactional
    public void approveRequestedStore(Long storeRequestNo) {
        StoreRegistration storeRegistration = getStoreRegistration(storeRequestNo);

        checkIsDeleted(storeRegistration);

        // 승인되지 않았을 경우에만, 승인 로직 타기
        if (!APPROVED.equals(storeRegistration.getStatus())) {
            storeRegistration.setStatus(APPROVED);
            storeRegistrationRepository.save(storeRegistration);
            storeRepository.save(StoreMapper.INSTANCE.toStore(storeRegistration));
        }

    }

    // 2. 거절
    @Transactional
    public Long rejectRequestedStore(Long storeRegistrationNo, StoreRegistrationUpdateDto storeRegistrationUpdateDto) {
        StoreRegistration storeRegistration = getStoreRegistration(storeRegistrationNo);

        checkIsDeleted(storeRegistration);

        storeRegistration.setStatus(REJECTED);
        storeRegistration.setRejectReason(storeRegistrationUpdateDto.getRejectType());
        storeRegistration.setRejectType(storeRegistrationUpdateDto.getRejectReason());

        // 이미 승인된 storeRegistration을 거절하는 경우는, 이미 승인된 store를 삭제해야한다
        if (APPROVED.equals(storeRegistration.getStatus())) {
            // 1. 승인된 store 찾기
            Store store = storeRepository.findByStoreRegistrationNo(storeRegistrationNo)
                    .orElseThrow(() -> {
                        log.error("storeRegistrationNo : {} / 존재하지 않는 store 입니다.", storeRegistrationNo);
                        return new NotFoundStoreException(ErrorCode.STORE_NOT_FOUND);
                    });
            // 2. isDeleted = "Y"로 변경하기
            store.setIsDeleted("Y");
            // 3. 변경한 store 저장하기
            storeRepository.save(store);
        }

        // 일반적인 거절
        return storeRegistrationRepository.save(storeRegistration).getStoreRegistrationNo();
    }

    private void checkIsDeleted(StoreRegistration storeRegistration) {
        if (DELETED.equals(storeRegistration.getIsDeleted())) {
            log.error("storeRegistrationNo : {} / 삭제된 storeRegistration 입니다.", storeRegistration.getStoreRegistrationNo());
            throw new NotFoundStoreRegistrationException(ErrorCode.STORE_REGISTRATION_NOT_FOUND);
        }
    }

    private StoreRegistration getStoreRegistration(Long storeRegistrationNo) {
        StoreRegistration storeRegistration = storeRegistrationRepository.findById(storeRegistrationNo)
                .orElseThrow(() -> {
                            log.error("storeRegistrationNo : {} / 존재하지 않는 storeRegistration 입니다.", storeRegistrationNo);
                            return new NotFoundStoreRegistrationException(ErrorCode.STORE_REGISTRATION_NOT_FOUND);
                        });

        return storeRegistration;
    }




}
