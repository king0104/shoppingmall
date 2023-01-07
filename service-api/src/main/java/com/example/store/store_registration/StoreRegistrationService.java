package com.example.store.store_registration;

import com.example.common.ErrorCode;
import com.example.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StoreRegistrationService {

    private final StoreRegistrationRepository storeRegistrationRepository;

    @Transactional
    public void save(StoreRegistrationSaveDto storeRegistrationSaveDto) {
        // Seller 계정으로 등록된 StoreRegistration 이 이미 있는 경우
        if (storeRegistrationRepository.existsBySellerNo(storeRegistrationSaveDto.getSellerNo())) {
            throw new CustomException(ErrorCode.MULTI_STORE_REGISTRATION);

        }
        storeRegistrationRepository.save(StoreRegistrationMapper.INSTANCE.toStoreRegistration(storeRegistrationSaveDto));

    }
}
