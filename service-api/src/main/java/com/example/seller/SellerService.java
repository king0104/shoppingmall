package com.example.seller;

import com.example.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;


}
