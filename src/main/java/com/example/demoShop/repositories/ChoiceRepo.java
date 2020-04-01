package com.example.demoShop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoShop.domain.Choice;

public interface ChoiceRepo extends JpaRepository<Choice, Long> {

}
