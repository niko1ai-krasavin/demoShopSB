package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.DiscountDTO;


public interface DiscountService {
	
	DiscountDTO findDiscountById(Long id);
	
	List<DiscountDTO> findAllDiscounts();
	
	void saveDiscount(DiscountDTO discountDTO);
	
	void deleteDiscountById(Long id);

}
