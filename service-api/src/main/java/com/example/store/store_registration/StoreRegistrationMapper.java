package com.example.store.store_registration;

import com.example.seller.Seller;
import com.example.seller.SellerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


// -- 엔티티가 아닌걸 구별하기 쉽지 않음 - DTO붙여주기
@Mapper(componentModel = "spring")
public interface StoreRegistrationMapper {

    StoreRegistrationMapper INSTANCE = Mappers.getMapper( StoreRegistrationMapper.class );
    // mapping 어노테이션은 변환되는 클래스 기준임.
    // ex) StoreRegistration.setter(...) 이런식
    @Mapping(target = "sellerNo", source = "sellerNo")
    StoreRegistrationSaveDto toStoreRegistrationSaveDto(StoreRegistrationSaveRequest request, Long sellerNo);


    default StoreRegistration toStoreRegistration(StoreRegistrationSaveDto storeRegistrationSaveDto, Seller seller) {
        StoreRegistration storeRegistration = new StoreRegistration();

        storeRegistration.setStoreRegistrationNo(storeRegistrationSaveDto.getSellerNo());
        storeRegistration.setSeller(seller);
        storeRegistration.setIntroduction(storeRegistrationSaveDto.getIntroduction());
        storeRegistration.setName(storeRegistrationSaveDto.getName());
        storeRegistration.setOpenTime(storeRegistrationSaveDto.getOpenTime());
        storeRegistration.setCloseTime(storeRegistrationSaveDto.getCloseTime());
        storeRegistration.setPhone(storeRegistrationSaveDto.getPhone());
        storeRegistration.setEmail(storeRegistrationSaveDto.getEmail());
        storeRegistration.setLocation(storeRegistrationSaveDto.getLocation());

        return storeRegistration;
    }
}
