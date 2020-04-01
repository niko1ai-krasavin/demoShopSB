package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Material;
import com.example.demoShop.dto.MaterialDTO;
import com.example.demoShop.repositories.MaterialRepository;
import com.example.demoShop.services.MaterialService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class MaterialServiceImpl implements MaterialService {
	
	private final MaterialRepository materialRepository;

	@Override
	public MaterialDTO findMaterialById(Long id) {
		Optional<Material> optionalMaterial = materialRepository.findById(id);
		Material material = optionalMaterial.get();
		
		MaterialDTO materialDTO = new MaterialDTO(material.getId(), material.getName());
		return materialDTO;
	}

	@Override
	public List<MaterialDTO> findAllMaterials() {
		List<MaterialDTO> materialDTOs = new ArrayList<>();
		List<Material> materials = materialRepository.findAll();
		for (Material material : materials) {
			MaterialDTO materialDTO = new MaterialDTO(material.getId(), material.getName());
			materialDTOs.add(materialDTO);
		}
		return materialDTOs;
	}

	@Override
	public void saveMaterial(MaterialDTO materialDTO) {
		Material material = new Material(materialDTO.getId(), materialDTO.getName());
		materialRepository.save(material);
	}

	@Override
	public void deleteMaterialById(Long id) {
		materialRepository.deleteById(id);
	}

}
