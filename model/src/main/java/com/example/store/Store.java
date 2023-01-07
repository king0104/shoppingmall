package com.example.store;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeNo;
    private Long storeRegistrationNo;
    private Long sellerNo;
    private String introduction;
    private String name;
    private LocalTime openTime; // 날짜 없는 시각은 localtime 사용
    private LocalTime closeTime;
    private String phone;
    private String email;
    private String location;
    private String status;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private String isDeleted = "N";


}
