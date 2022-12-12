package com.example.admin.entity;

import com.example.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// 중요한 어노테이션(삭제 안할 가능성이 높은 어노테이션)을 가깝게 붙이기
@ToString // test용
@Getter
@NoArgsConstructor
@Entity
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 반드시 설정해주어야 auto increment 된다
    private Long no;
    private String email;
    private String password;
    private String name;
    private String phone;

    // setter 대신 builder 패턴 사용
    @Builder
    public Admin(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

}
