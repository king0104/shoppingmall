package com.example.store.store_registration;

import com.example.common.ErrorCode;
import com.example.exception.CustomException;
import com.example.exception.DuplicatedStoreRegistrationException;
import com.example.exception.NotFoundSellerException;
import com.example.seller.Seller;
import com.example.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreRegistrationService {

    private final StoreRegistrationRepository storeRegistrationRepository;
    private final SellerRepository sellerRepository;

    @Transactional
    public void save(StoreRegistrationSaveDto storeRegistrationSaveDto) {
        // Seller 계정으로 등록된 StoreRegistration 이 이미 있는 경우
        if (storeRegistrationRepository.existsBySellerNo(storeRegistrationSaveDto.getSellerNo())) {
            throw new DuplicatedStoreRegistrationException(ErrorCode.MULTI_STORE_REGISTRATION);

        }
        storeRegistrationRepository.save(StoreRegistrationMapper.INSTANCE.toStoreRegistration(storeRegistrationSaveDto));
    }
}
