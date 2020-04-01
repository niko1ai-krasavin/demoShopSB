package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoShop.domain.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
