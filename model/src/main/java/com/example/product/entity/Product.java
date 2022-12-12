package com.example.product.entity;

import com.example.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long categoryNo;
    private Long storeNo;
    private String title;
    private int price;
    private int deliveryFee;
    private String brand;
    private String name;
    private String description;
    private String status;

    @Builder
    public Product(Long categoryNo, Long storeNo, String title, int price, int deliveryFee, String brand, String name, String description, String status) {
        this.categoryNo = categoryNo;
        this.storeNo = storeNo;
        this.title = title;
        this.price = price;
        this.deliveryFee = deliveryFee;
        this.brand = brand;
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
