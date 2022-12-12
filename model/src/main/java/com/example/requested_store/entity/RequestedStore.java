package com.example.requested_store.entity;

import com.example.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class RequestedStore extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long sellerNo;
    private String introduction;
    private String name;
    private LocalTime openTime; // 날짜 없는 시각은 localtime 사용
    private LocalTime closeTime;
    private String phone;
    private String email;
    private String location;
    private String rejectType;
    private String rejectReason;
    // createdAt, updatedAt, isDeleted는 BaseEntity에 있음

    // no 제외 생성자
    @Builder
    public RequestedStore(Long sellerNo, String introduction, String name, LocalTime openTime, LocalTime closeTime, String phone, String email, String location, String rejectType, String rejectReason) {
        this.sellerNo = sellerNo;
        this.introduction = introduction;
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.rejectType = rejectType;
        this.rejectReason = rejectReason;
    }

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();
    }

}
