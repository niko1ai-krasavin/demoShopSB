package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.ManufacturerDTO;


public interface ManufacturerService {
	
	ManufacturerDTO findManufacturerById(Long id);
	
	List<ManufacturerDTO> findAllManufacturers();
	
	void saveManufacturer(ManufacturerDTO manufacturerDTO);
	
	void deleteManufacturerById (Long id);

}
