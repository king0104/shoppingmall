package com.example.store.store_registration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRegistrationRepository extends JpaRepository<StoreRegistration, Long>, CustomStoreRegistrationRepository {
    // 1개 이상 존재하는지 존재하지 않는지
    boolean existsBySellerNo(Long sellerNo);
}
