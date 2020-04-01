package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.MaterialDTO;
import com.example.demoShop.services.MaterialService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(MaterialController.BASE_MATERIAL_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class MaterialController {
	
	public static final String BASE_MATERIAL_URL = "/api/material";
	
	@Autowired
	private final MaterialService materialService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<MaterialDTO> findAllMaterials() {
		return materialService.findAllMaterials();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MaterialDTO findMaterialById(@PathVariable Long id) {
		return materialService.findMaterialById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<MaterialDTO> saveMaterial(@RequestBody MaterialDTO materialDTO) {
		materialService.saveMaterial(materialDTO);
		return materialService.findAllMaterials();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<MaterialDTO> deleteMaterialById(@PathVariable Long id) {
		materialService.deleteMaterialById(id);
		return materialService.findAllMaterials();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<MaterialDTO> updateMaterial(@RequestBody MaterialDTO materialDTO) {
		materialService.saveMaterial(materialDTO);
		return materialService.findAllMaterials();
	}

}
