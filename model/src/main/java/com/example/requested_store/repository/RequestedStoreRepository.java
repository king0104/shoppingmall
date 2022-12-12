package com.example.requested_store.repository;

import com.example.requested_store.entity.RequestedStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestedStoreRepository extends JpaRepository<RequestedStore, Long> {

}
