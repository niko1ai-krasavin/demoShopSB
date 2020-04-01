package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.TypeDTO;
import com.example.demoShop.services.TypeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(TypeController.BASE_TYPE_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class TypeController {
	
	public static final String BASE_TYPE_URL = "/api/type";
	
	@Autowired
	private final TypeService typeService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<TypeDTO> findAllTypes() {
		return typeService.findAllTypes();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public TypeDTO findTypeById(@PathVariable Long id) {
		return typeService.findTypeById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<TypeDTO> saveType(@RequestBody TypeDTO typeDTO) {
		typeService.saveType(typeDTO);
		return typeService.findAllTypes();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<TypeDTO> deleteTypeById(@PathVariable Long id) {
		typeService.deleteTypeById(id);
		return typeService.findAllTypes();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<TypeDTO> updateType(@RequestBody TypeDTO typeDTO) {
		typeService.saveType(typeDTO);
		return typeService.findAllTypes();
	}

}
