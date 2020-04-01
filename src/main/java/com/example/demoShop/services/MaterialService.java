package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.MaterialDTO;


public interface MaterialService {
	
	MaterialDTO findMaterialById(Long id);
	
	List<MaterialDTO> findAllMaterials();
	
	void saveMaterial(MaterialDTO materialDTO);
	
	void deleteMaterialById(Long id);

}
