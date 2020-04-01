package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoShop.domain.Orderuser;

public interface OrderRepo extends JpaRepository<Orderuser, Long> {

}
