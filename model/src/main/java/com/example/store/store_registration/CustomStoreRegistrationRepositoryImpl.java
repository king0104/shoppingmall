package com.example.store.store_registration;

import com.example.seller.QSeller;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// querydslsupport
// QuerydslRepositorySupport
@Slf4j
public class CustomStoreRegistrationRepositoryImpl extends QuerydslRepositorySupport implements CustomStoreRegistrationRepository {
    private static final String DELETE = "Y";
    private static final String NOT_DELETE = "N";
    QStoreRegistration storeRegistration = QStoreRegistration.storeRegistration;
    QSeller seller = QSeller.seller;

    public CustomStoreRegistrationRepositoryImpl() {
        super(StoreRegistration.class);
    }

    @Override
    public List<StoreRegistration> findAll(Integer offset, Integer limit, LocalDateTime firstTime, LocalDateTime lastTime, String isDeleted) {
        return from(storeRegistration)
                .join(storeRegistration.seller, seller).fetchJoin() // LAZY 로딩 & fetch join
                .where(
                        storeRegistration.createdAt.between(firstTime, lastTime)
                            .and(isDeletedEq(isDeleted))
                )
                .offset(offset).limit(limit)
                .fetch();
    }

    private BooleanExpression isDeletedEq(String isDeleted) {
        if (StringUtils.isNotBlank(isDeleted)) { // isNotBlank, isBlank
            if (isDeleted.equals(DELETE)) {
                return storeRegistration.isDeleted.eq(DELETE);
            }
            return storeRegistration.isDeleted.eq(NOT_DELETE);
        }
        return null;
    }

    public boolean existsBySellerNo(Long sellerNo) {
        StoreRegistration storeRegistrationEntity = from(storeRegistration)
                .where(storeRegistration.seller.sellerNo.eq(sellerNo))
                .fetchFirst();// == limit(1).fetchOne() : 결과 없으면 null 반환

        return storeRegistrationEntity != null;
    }

}
