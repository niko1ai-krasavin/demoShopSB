package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Type;
import com.example.demoShop.dto.TypeDTO;
import com.example.demoShop.repositories.TypeRepository;
import com.example.demoShop.services.TypeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {
	
	private final TypeRepository typeRepository;

	@Override
	public TypeDTO findTypeById(Long id) {
		Optional<Type> optionalType = typeRepository.findById(id);
		Type type = optionalType.get();
		
		TypeDTO typeDTO = new TypeDTO(type.getId(), type.getName());
		return typeDTO;
	}

	@Override
	public List<TypeDTO> findAllTypes() {
		List<TypeDTO> typeDTOs = new ArrayList<>();
		List<Type> types = typeRepository.findAll();
		for (Type type : types) {
			TypeDTO typeDTO = new TypeDTO(type.getId(), type.getName());
			typeDTOs.add(typeDTO);
		}
		return typeDTOs;
	}

	@Override
	public void saveType(TypeDTO typeDTO) {
		Type type = new Type(typeDTO.getId(), typeDTO.getName());
		typeRepository.save(type);
	}

	@Override
	public void deleteTypeById(Long id) {
		typeRepository.deleteById(id);
	}

}
