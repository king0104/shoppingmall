package com.example.seller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SellerRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;

}