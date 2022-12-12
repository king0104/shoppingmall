package com.example.category.entity;

import com.example.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long parentNo;
    private String name;
    private int depth;

    @Builder
    public Category(Long parentNo, String name, int depth) {
        this.parentNo = parentNo;
        this.name = name;
        this.depth = depth;
    }
}
