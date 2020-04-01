package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.DiscountDTO;
import com.example.demoShop.services.DiscountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(DiscountController.BASE_DISCOUNT_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class DiscountController {
	
	public static final String BASE_DISCOUNT_URL = "/api/discount";
	
	@Autowired
	private final DiscountService discountService;
	
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<DiscountDTO> findAllDiscounts() {
		return discountService.findAllDiscounts();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DiscountDTO findDiscountById(@PathVariable Long id) {
		return discountService.findDiscountById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<DiscountDTO> saveDiscount(@RequestBody DiscountDTO discountDTO) {
		discountService.saveDiscount(discountDTO);
		return discountService.findAllDiscounts();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<DiscountDTO> deleteDiscountById(@PathVariable Long id) {
		discountService.deleteDiscountById(id);
		return discountService.findAllDiscounts();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<DiscountDTO> updateDiscount(@RequestBody DiscountDTO discountDTO) {
		discountService.saveDiscount(discountDTO);
		return discountService.findAllDiscounts();
	}

}
