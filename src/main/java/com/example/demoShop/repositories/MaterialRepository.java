package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoShop.domain.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
