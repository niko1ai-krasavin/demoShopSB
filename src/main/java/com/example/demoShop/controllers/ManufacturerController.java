package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.ManufacturerDTO;
import com.example.demoShop.services.ManufacturerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(ManufacturerController.BASE_MANUFACTURER_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ManufacturerController {
	
	public static final String BASE_MANUFACTURER_URL = "/api/manufacturer";
	
	@Autowired
	private final ManufacturerService manufacturerService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ManufacturerDTO> findAllManufacturers() {
		return manufacturerService.findAllManufacturers();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ManufacturerDTO findManufacturerById(@PathVariable Long id) {
		return manufacturerService.findManufacturerById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ManufacturerDTO> saveManufacturer(@RequestBody ManufacturerDTO manufacturerDTO) {
		manufacturerService.saveManufacturer(manufacturerDTO);
		return manufacturerService.findAllManufacturers();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<ManufacturerDTO> deleteManufacturerById(@PathVariable Long id) {
		manufacturerService.deleteManufacturerById(id);
		return manufacturerService.findAllManufacturers();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<ManufacturerDTO> updateColor(@RequestBody ManufacturerDTO manufacturerDTO) {
		manufacturerService.saveManufacturer(manufacturerDTO);
		return manufacturerService.findAllManufacturers();
	}

}
