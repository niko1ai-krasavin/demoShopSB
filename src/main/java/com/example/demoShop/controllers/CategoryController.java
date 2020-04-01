package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.CategoryDTO;
import com.example.demoShop.services.CategoryService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(CategoryController.BASE_CATEGORY_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
	
	public static final String BASE_CATEGORY_URL = "/api/category";
	
	@Autowired
	private final CategoryService categoryService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> findAllCategories() {
		return categoryService.findAllCategories();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTO findCategoryrById(@PathVariable Long id) {
		return categoryService.findCategoryById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.saveCategory(categoryDTO);
		return categoryService.findAllCategories();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> deleteCateryById(@PathVariable Long id) {
		categoryService.deleteCategoryById(id);
		return categoryService.findAllCategories();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.saveCategory(categoryDTO);
		
		return categoryService.findAllCategories();
	}

}
