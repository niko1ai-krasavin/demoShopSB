package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoShop.domain.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
