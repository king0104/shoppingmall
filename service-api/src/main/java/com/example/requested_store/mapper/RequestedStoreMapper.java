package com.example.requested_store.mapper;

import com.example.requested_store.dto.RequestedStoreSave;
import com.example.requested_store.dto.RequestedStoreSaveRequest;
import com.example.requested_store.entity.RequestedStore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

// interface 대신 abstract 으로 하니까 오류 해결
@Mapper(componentModel = "spring")
public abstract class RequestedStoreMapper {

    public abstract RequestedStoreSave toRequestedStoreSave(RequestedStoreSaveRequest request);
    public abstract RequestedStore toRequestedStore(RequestedStoreSave requestedStoreSave);


}
