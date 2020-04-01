package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.SizeDTO;


public interface SizeService {
	
	SizeDTO findSizeById(Long id);
	
	List<SizeDTO> findAllSizes();
	
	void saveSize(SizeDTO sizeDTO);
	
	void deleteSizeById (Long id);

}
