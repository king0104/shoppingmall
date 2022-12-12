package com.example.requested_store.service;

import com.example.requested_store.dto.RequestedStoreSave;
import com.example.requested_store.mapper.RequestedStoreMapper;
import com.example.requested_store.repository.RequestedStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RequestedStoreService {

    private final RequestedStoreRepository requestedStoreRepository;
    private final RequestedStoreMapper mapper;

    @Transactional
    public Long save(RequestedStoreSave requestedStoreSave) {
        return requestedStoreRepository.save(mapper.toRequestedStore(requestedStoreSave)).getNo();
    }
}
