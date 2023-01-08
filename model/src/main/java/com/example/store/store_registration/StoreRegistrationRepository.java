package com.example.store.store_registration;

import com.example.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StoreRegistrationRepository extends JpaRepository<StoreRegistration, Long>, CustomStoreRegistrationRepository {

}
