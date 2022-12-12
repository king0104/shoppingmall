package com.example.requested_store.controller;

import com.example.requested_store.dto.RequestedStoreSave;
import com.example.requested_store.dto.RequestedStoreSaveRequest;
import com.example.requested_store.mapper.RequestedStoreMapper;
import com.example.requested_store.service.RequestedStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RequestedStoreController {

    private final RequestedStoreService requestedStoreService;
    private final RequestedStoreMapper mapper;

    @PostMapping("/api/requested-store/register")
    public Long register(@RequestBody RequestedStoreSaveRequest request) {
        return requestedStoreService.save(mapper.toRequestedStoreSave(request));
    }
}
