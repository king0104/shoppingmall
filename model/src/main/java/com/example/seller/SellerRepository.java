package com.example.seller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SellerRepository extends JpaRepository<Seller, Long> {
    // repository 부분에서 NPE 뜨는 것 방지하기 위해 Optional로 가져오자!!!(코딩컨벤션)
    Optional<Seller> findSellerByEmail(String email);

//    @Query(value = "select * from seller where email:=email", nativeQuery = true)
//    Optional<Seller> findByEmail(@Param("email") String email);
}
