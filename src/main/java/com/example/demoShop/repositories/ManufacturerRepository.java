package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoShop.domain.Manufacturer;


@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
