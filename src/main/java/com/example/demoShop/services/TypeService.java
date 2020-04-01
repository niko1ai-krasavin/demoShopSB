package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.TypeDTO;


public interface TypeService {
	
	TypeDTO findTypeById(Long id);
	
	List<TypeDTO> findAllTypes();
	
	void saveType(TypeDTO typeDTO);
	
	void deleteTypeById (Long id);

}
