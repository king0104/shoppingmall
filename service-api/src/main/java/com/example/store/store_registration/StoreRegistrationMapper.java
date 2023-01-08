package com.example.store.store_registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


// -- 엔티티가 아닌걸 구별하기 쉽지 않음 - DTO붙여주기
@Mapper(componentModel = "spring")
public interface StoreRegistrationMapper {

    StoreRegistrationMapper INSTANCE = Mappers.getMapper( StoreRegistrationMapper.class );
    // mapping 어노테이션은 변환되는 클래스 기준임.
    // ex) StoreRegistration.setter(...) 이런식
    StoreRegistrationSaveDto toStoreRegistrationSaveDto(StoreRegistrationSaveRequest request);
    @Mapping(source = "sellerNo", target = "seller") // 이걸 어떻게 해야하지..?
    // mapstruct & 컬럼을 엔티티로 바꾸는걸 어떻게함?
    StoreRegistration toStoreRegistration(StoreRegistrationSaveDto storeRegistrationSaveDto);

}
