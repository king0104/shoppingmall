package com.example.store.store_registration;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// interface 대신 abstract 으로 하니까 오류 해결
@Mapper(componentModel = "spring")
public interface StoreRegistrationMapper {

    StoreRegistrationMapper INSTANCE = Mappers.getMapper( StoreRegistrationMapper.class );

    StoreRegistrationResponse toResponse(StoreRegistrationDto dto);
    StoreRegistrationDto toDto(StoreRegistration storeRegistration);
    StoreRegistrationUpdateDto toUpdateDto(StoreRegistrationUpdateRequest request);

}