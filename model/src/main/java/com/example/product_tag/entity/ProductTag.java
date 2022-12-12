package com.example.product_tag.entity;

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
public class ProductTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long productNo;
    private Long tagNo;

    @Builder
    public ProductTag(Long productNo, Long tagNo) {
        this.productNo = productNo;
        this.tagNo = tagNo;
    }
}
