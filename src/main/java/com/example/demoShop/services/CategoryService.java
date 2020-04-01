package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.CategoryDTO;


public interface CategoryService {
	
	CategoryDTO findCategoryById(Long id);
	
	List<CategoryDTO> findAllCategories();
	
	void saveCategory(CategoryDTO categoryDTO);
	
	void deleteCategoryById (Long id);

}
