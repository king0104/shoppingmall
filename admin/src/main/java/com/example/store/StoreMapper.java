package com.example.store;

import com.example.store.store_registration.StoreRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper( StoreMapper.class );

    // request store 를 store로 바꾸기
    @Mapping(target = "status", constant = "close")
//    @Mapping(source = "seller", ignore = true)
    Store toStore(StoreRegistration storeRegistration);

}
