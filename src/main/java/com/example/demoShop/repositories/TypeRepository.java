package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoShop.domain.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
