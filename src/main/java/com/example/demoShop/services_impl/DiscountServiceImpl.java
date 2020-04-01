package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Discount;
import com.example.demoShop.dto.DiscountDTO;
import com.example.demoShop.repositories.DiscountRepository;
import com.example.demoShop.services.DiscountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DiscountServiceImpl implements DiscountService {
	
	private final DiscountRepository discountRepository;

	@Override
	public DiscountDTO findDiscountById(Long id) {
		Optional<Discount> optionalDiscount = discountRepository.findById(id);
		Discount discount = optionalDiscount.get();
		
		DiscountDTO discountDTO = new DiscountDTO(discount.getId(), discount.getDiscountValue());
		return discountDTO;
	}

	@Override
	public List<DiscountDTO> findAllDiscounts() {
		List<DiscountDTO> discountDTOs = new ArrayList<>();
		List<Discount> discounts = discountRepository.findAll();
		for (Discount discount : discounts) {
			DiscountDTO discountDTO = new DiscountDTO(discount.getId(), discount.getDiscountValue());
			discountDTOs.add(discountDTO);
		}
		return discountDTOs;
	}

	@Override
	public void saveDiscount(DiscountDTO discountDTO) {
		
		Discount discount = new Discount(discountDTO.getId(), discountDTO.getDiscountValue());
		discountRepository.save(discount);
	}

	@Override
	public void deleteDiscountById(Long id) {
		discountRepository.deleteById(id);
	}

}
