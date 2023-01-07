package com.example.store;

import com.example.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByStoreRegistrationNo(Long storeRegistrationNo);
}
