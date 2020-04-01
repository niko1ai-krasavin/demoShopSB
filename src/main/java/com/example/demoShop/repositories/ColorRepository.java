package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoShop.domain.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

}
