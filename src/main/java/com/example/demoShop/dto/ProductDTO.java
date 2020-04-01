package com.example.demoShop.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private Integer quantityInStock;
	private Double price;
	private String description;
	
	private CategoryDTO category;
	private TypeDTO type;
	private ManufacturerDTO manufacturer;
	private SizeDTO size;
	private ColorDTO color;
	private Set<MaterialDTO> materials;
	private DiscountDTO discount;
	
	

}
