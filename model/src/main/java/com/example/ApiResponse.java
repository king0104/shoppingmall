package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
    private boolean success;
    private T data;
    private String errorCode; // -- wrapper 타입, null 가능하니까
}
