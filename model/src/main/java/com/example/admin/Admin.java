package com.example.admin;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

// 중요한 어노테이션(삭제 안할 가능성이 높은 어노테이션)을 가깝게 붙이기
@ToString // test용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 반드시 설정해주어야 auto increment 된다
    private Long adminNo;
    private String email;
    private String password;
    private String name;
    private String phone;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private String isDeleted = "N";


}
