package com.example.demoShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demoShop.dto.ProductDTO;
import com.example.demoShop.services.ProductService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping(ProductController.BASE_PRODUCT_URL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
	
	public static final String BASE_PRODUCT_URL = "/api/product";
	
	@Autowired
	private final ProductService productService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> findAllProducts()  {
		return productService.findAllProducts();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDTO findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	
	@PostMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
		productService.saveProduct(productDTO);
		return productService.findAllProducts();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
		return productService.findAllProducts();
	}
	
	@PutMapping()
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
		productService.saveProduct(productDTO);
		return productService.findAllProducts();
	}

}
