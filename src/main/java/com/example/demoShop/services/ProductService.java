package com.example.demoShop.services;

import java.util.List;

import com.example.demoShop.dto.ProductDTO;


public interface ProductService {
	
	ProductDTO findProductById(Long id);
	
	List<ProductDTO> findAllProducts();
	
	void saveProduct(ProductDTO productDTO);
	
	void deleteProductById (Long id);

}
