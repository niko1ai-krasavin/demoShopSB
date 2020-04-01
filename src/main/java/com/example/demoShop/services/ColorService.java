package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.ColorDTO;


public interface ColorService {
	
	
	ColorDTO findColorById(Long id);
	
	List<ColorDTO> findAllColors();
	
	void saveColor(ColorDTO colorDTO);
	
	void deleteColorById (Long id);

	
}
