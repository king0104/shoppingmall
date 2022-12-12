package com.example.requested_store.mapper;

import com.example.requested_store.dto.RequestedStoreSave;
import com.example.requested_store.dto.RequestedStoreSaveRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequestedStoreMapperTest {

    RequestedStoreMapper INSTANCE = Mappers.getMapper(RequestedStoreMapper.class);

    @Test
    void test() {
        RequestedStoreSaveRequest request = RequestedStoreSaveRequest.builder()
                .rejectReason("hi")
                .rejectType("hi")
                .sellerNo(1L)
                .introduction("hihihi")
                .closeTime(LocalTime.now())
                .email("email")
                .location("dongtan")
                .name("yoon")
                .openTime(LocalTime.now())
                .phone("01033333333")
                .build();

        RequestedStoreSave requestedStoreSave = INSTANCE.toRequestedStoreSave(request);

        System.out.println("requestedStoreSave = " + requestedStoreSave);

    }
}