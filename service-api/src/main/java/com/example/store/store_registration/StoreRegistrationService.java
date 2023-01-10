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
        // 1. seller 가져오기 (이 로직이 mapper 안에 들어가는게 낫나..?)
        Seller seller = sellerRepository.findById(storeRegistrationSaveDto.getSellerNo())
                .orElseThrow(() -> new NotFoundSellerException(ErrorCode.SELLER_NOT_FOUND));
        // 2. storeRegistration 저장
        storeRegistrationRepository.save(StoreRegistrationMapper.INSTANCE.toStoreRegistration(storeRegistrationSaveDto, seller));
    }
}
