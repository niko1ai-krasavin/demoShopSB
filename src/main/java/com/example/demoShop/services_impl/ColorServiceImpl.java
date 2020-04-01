package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Color;
import com.example.demoShop.dto.ColorDTO;
import com.example.demoShop.repositories.ColorRepository;
import com.example.demoShop.services.ColorService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ColorServiceImpl implements ColorService {
	
	private final ColorRepository colorRepository;

	@Override
	public ColorDTO findColorById(Long id) {
		Optional<Color> optionalColor = colorRepository.findById(id);
		Color color = optionalColor.get();
		
		ColorDTO colorDTO = new ColorDTO(color.getId(), color.getName());
		return colorDTO;
	}

	@Override
	public List<ColorDTO> findAllColors() {
		List<ColorDTO> colorDTOs = new ArrayList<>();
		List<Color> colors = colorRepository.findAll();
		for (Color color : colors) {
			ColorDTO colorDTO = new ColorDTO(color.getId(), color.getName());
			colorDTOs.add(colorDTO);
		}
		return colorDTOs;
	}

	@Override
	public void saveColor(ColorDTO colorDTO) {
		Color color = new Color(colorDTO.getId(), colorDTO.getName());
		
		colorRepository.save(color);
	}

	@Override
	public void deleteColorById(Long id) {
		colorRepository.deleteById(id);
	}

}
