package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoShop.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
