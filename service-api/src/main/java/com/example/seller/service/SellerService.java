package com.example.seller.service;

import com.example.seller.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;


}
