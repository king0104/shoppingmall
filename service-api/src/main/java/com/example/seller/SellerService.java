package com.example.seller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;


}
