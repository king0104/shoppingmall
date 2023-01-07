package com.example.store.store_registration;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomStoreRegistrationRepository {
    List<StoreRegistration> findAll(Integer offset, Integer limit, LocalDateTime startTime, LocalDateTime lastTime, String isDeleted);
}
