package com.example.seller.repository;

import com.example.seller.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SellerRepository extends JpaRepository<Seller, Long> {

}
