package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.ColorDTO;
import com.example.demoShop.services.ColorService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(ColorController.BASE_COLOR_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ColorController {
	
	public static final String BASE_COLOR_URL = "/api/color";
	
	@Autowired
	private final ColorService colorService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ColorDTO> findAllColors() {
		return colorService.findAllColors();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ColorDTO findColorById(@PathVariable Long id) {
		return colorService.findColorById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ColorDTO> saveColor(@RequestBody ColorDTO colorDTO) {
		colorService.saveColor(colorDTO);
		return colorService.findAllColors();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<ColorDTO> deleteColorById(@PathVariable Long id) {
		colorService.deleteColorById(id);
		return colorService.findAllColors();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<ColorDTO> updateColor(@RequestBody ColorDTO colorDTO) {
		colorService.saveColor(colorDTO);
		return colorService.findAllColors();
	}

}
