package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Size;
import com.example.demoShop.dto.SizeDTO;
import com.example.demoShop.repositories.SizeRepository;
import com.example.demoShop.services.SizeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class SizeServiceImpl implements SizeService {
	
	private final SizeRepository sizeRepository;

	@Override
	public SizeDTO findSizeById(Long id) {
		Optional<Size> optionalSize = sizeRepository.findById(id);
		Size size = optionalSize.get();
		
		SizeDTO sizeDTO = new SizeDTO(size.getId(), size.getName());
		return sizeDTO;
	}

	@Override
	public List<SizeDTO> findAllSizes() {
		List<SizeDTO> sizeDTOs = new ArrayList<>();
		List<Size> sizes = sizeRepository.findAll();
		for (Size size : sizes) {
			SizeDTO sizeDTO = new SizeDTO(size.getId(), size.getName());
			sizeDTOs.add(sizeDTO);
		}
		return sizeDTOs;
	}

	@Override
	public void saveSize(SizeDTO sizeDTO) {
		Size size = new Size(sizeDTO.getId(), sizeDTO.getName());
		sizeRepository.save(size);
	}

	@Override
	public void deleteSizeById(Long id) {
		sizeRepository.deleteById(id);
	}

}
