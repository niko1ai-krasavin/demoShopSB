package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.SizeDTO;
import com.example.demoShop.services.SizeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(SizeController.BASE_SIZE_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class SizeController {
	
	public final static String BASE_SIZE_URL = "/api/size";
	
	@Autowired
	private final SizeService sizeService;
	
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<SizeDTO> findAllSizes() {
		return sizeService.findAllSizes();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SizeDTO findSizeById(@PathVariable Long id) {
		return sizeService.findSizeById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<SizeDTO> saveSize(@RequestBody SizeDTO sizeDTO) {
		sizeService.saveSize(sizeDTO);
		return sizeService.findAllSizes();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<SizeDTO> deleteSizeById(@PathVariable Long id) {
		sizeService.deleteSizeById(id);
		return sizeService.findAllSizes();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<SizeDTO> updateSize(@RequestBody SizeDTO sizeDTO) {
		sizeService.saveSize(sizeDTO);
		return sizeService.findAllSizes();
	}
	
	

}
