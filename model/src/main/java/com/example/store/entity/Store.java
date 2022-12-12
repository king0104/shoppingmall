package com.example.store.entity;

import com.example.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class Store extends BaseEntity {
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

    @Builder
    public Store(Long sellerNo, String introduction, String name, LocalTime openTime, LocalTime closeTime, String phone, String email, String location) {
        this.sellerNo = sellerNo;
        this.introduction = introduction;
        this.name = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.phone = phone;
        this.email = email;
        this.location = location;
    }
}
