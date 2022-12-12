package com.example.requested_store.mapper;

import com.example.requested_store.dto.RequestedStoreSave;
import com.example.requested_store.dto.RequestedStoreSaveRequest;
import com.example.requested_store.entity.RequestedStore;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-12T12:35:40+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class RequestedStoreMapperImpl extends RequestedStoreMapper {

    @Override
    public RequestedStoreSave toRequestedStoreSave(RequestedStoreSaveRequest request) {
        if ( request == null ) {
            return null;
        }

        RequestedStoreSave.RequestedStoreSaveBuilder requestedStoreSave = RequestedStoreSave.builder();

        requestedStoreSave.sellerNo( request.getSellerNo() );
        requestedStoreSave.introduction( request.getIntroduction() );
        requestedStoreSave.name( request.getName() );
        requestedStoreSave.openTime( request.getOpenTime() );
        requestedStoreSave.closeTime( request.getCloseTime() );
        requestedStoreSave.phone( request.getPhone() );
        requestedStoreSave.email( request.getEmail() );
        requestedStoreSave.location( request.getLocation() );
        requestedStoreSave.rejectType( request.getRejectType() );
        requestedStoreSave.rejectReason( request.getRejectReason() );

        return requestedStoreSave.build();
    }

    @Override
    public RequestedStore toRequestedStore(RequestedStoreSave requestedStoreSave) {
        if ( requestedStoreSave == null ) {
            return null;
        }

        RequestedStore.RequestedStoreBuilder requestedStore = RequestedStore.builder();

        requestedStore.sellerNo( requestedStoreSave.getSellerNo() );
        requestedStore.introduction( requestedStoreSave.getIntroduction() );
        requestedStore.name( requestedStoreSave.getName() );
        requestedStore.openTime( requestedStoreSave.getOpenTime() );
        requestedStore.closeTime( requestedStoreSave.getCloseTime() );
        requestedStore.phone( requestedStoreSave.getPhone() );
        requestedStore.email( requestedStoreSave.getEmail() );
        requestedStore.location( requestedStoreSave.getLocation() );
        requestedStore.rejectType( requestedStoreSave.getRejectType() );
        requestedStore.rejectReason( requestedStoreSave.getRejectReason() );

        return requestedStore.build();
    }
}
