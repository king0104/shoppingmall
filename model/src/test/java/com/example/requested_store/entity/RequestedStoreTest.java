package com.example.requested_store.entity;

import com.example.requested_store.repository.RequestedStoreRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@RequiredArgsConstructor
@SpringBootTest
class RequestedStoreTest {

    @Autowired
    RequestedStoreRepository requestedStoreRepository;

    @Test
    void test() {
        RequestedStore requestedStore = RequestedStore.builder()
                .build();

        RequestedStore savedRequestedStore = requestedStoreRepository.save(requestedStore);

        System.out.println(savedRequestedStore.getCreatedAt());
        System.out.println(savedRequestedStore.getUpdatedAt());
        System.out.println(savedRequestedStore.getIsDeleted());

    }


    private static List<Field> getAllFields(Class clazz) {
        List<Field> fields = new ArrayList<Field>();

        fields.addAll(Arrays.asList( clazz.getDeclaredFields() ));

        Class superClazz = clazz.getSuperclass();
        if(superClazz != null){
            fields.addAll( getAllFields(superClazz) );
        }

        return fields;
    }
}