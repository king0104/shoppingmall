package com.example.seller;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SellerDto {
    private Long sellerNo;
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String phone;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String isDeleted;
}
