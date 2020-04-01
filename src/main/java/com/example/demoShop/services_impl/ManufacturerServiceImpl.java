package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Manufacturer;
import com.example.demoShop.dto.ManufacturerDTO;
import com.example.demoShop.repositories.ManufacturerRepository;
import com.example.demoShop.services.ManufacturerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	private final ManufacturerRepository manufacturerRepository;

	@Override
	public ManufacturerDTO findManufacturerById(Long id) {
		Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
		Manufacturer manufacturer = optionalManufacturer.get();
		
		ManufacturerDTO manufacturerDTO = new ManufacturerDTO(manufacturer.getId(), manufacturer.getName());
		return manufacturerDTO;
	}

	@Override
	public List<ManufacturerDTO> findAllManufacturers() {
		List<ManufacturerDTO> manufacturerDTOs = new ArrayList<>();
		List<Manufacturer> manufacturers = manufacturerRepository.findAll();
		for (Manufacturer manufacturer : manufacturers) {
			ManufacturerDTO manufacturerDTO = new ManufacturerDTO(manufacturer.getId(), manufacturer.getName());
			manufacturerDTOs.add(manufacturerDTO);
		}
		return manufacturerDTOs;
	}

	@Override
	public void saveManufacturer(ManufacturerDTO manufacturerDTO) {
		Manufacturer manufacturer = new Manufacturer(manufacturerDTO.getId(), manufacturerDTO.getName());
		manufacturerRepository.save(manufacturer);
	}

	@Override
	public void deleteManufacturerById(Long id) {
		manufacturerRepository.deleteById(id);
	}

}
