package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "COMMON-001", "유효성 검증에 실패한 경우"),
    INVALID_INPUT_JSON_VALUE(400, "COMMON-002", "올바르지 않은 JSON이 들어온 경우"),
//    INTERNAL_SERVER_ERROR(500, "COMMON-003", "서버에서 처리할 수 없는 경우"),

//    DUPLICATE_LOGIN_ID(400, "ACCOUNT-001", "계정명이 중복된 경우"),
//    UNAUTHORIZED(401, "ACCOUNT-002", "인증에 실패한 경우"),
//    ACCOUNT_NOT_FOUND(404, "ACCOUNT-003", "계정을 찾을 수 없는 경우"),
//    ROLE_NOT_EXISTS(403, "ACCOUNT-004", "권한이 부족한 경우"),
//    TOKEN_NOT_EXISTS(404, "ACCOUNT-005", "해당 key의 인증 토큰이 존재하지 않는 경우"),

//    ARTIST_NOT_FOUND(404, "ARTIST-001", "가수를 찾을 수 없는 경우"),

    SELLER_NOT_FOUND(404, "SELLER-001", "seller를 찾을 수 없는 경우"),

//    CONTEST_INVALID_DATE(400, "CONTEST-001", "선정 곡 날짜가 적절치 않은 경우"),

    MULTI_STORE_REGISTRATION(400, "STORE_REGISTRATION-001", "이미 해당 게정으로 등록된 STORE가 있는 경우");

    private final int status;
    private final String code;
    private final String message;



}