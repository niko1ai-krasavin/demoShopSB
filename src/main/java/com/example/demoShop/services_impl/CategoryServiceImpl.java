package com.example.demoShop.services_impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Category;
import com.example.demoShop.dto.CategoryDTO;
//import com.example.demoShop.mapping.CategoryMapper;
import com.example.demoShop.repositories.CategoryRepository;
import com.example.demoShop.services.CategoryService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	@Override
	public CategoryDTO findCategoryById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		Category category = optionalCategory.get();
		
		CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName());
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO> findAllCategories() {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName());
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	@Override
	public void saveCategory(CategoryDTO categoryDTO) {
		
		Category category = new Category(categoryDTO.getId(), categoryDTO.getName());
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}


}
