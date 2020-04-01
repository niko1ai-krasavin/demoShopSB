package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoShop.domain.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
