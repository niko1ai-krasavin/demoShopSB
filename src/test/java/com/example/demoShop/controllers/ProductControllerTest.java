package com.example.demoShop.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demoShop.dto.CategoryDTO;
import com.example.demoShop.dto.ColorDTO;
import com.example.demoShop.dto.DiscountDTO;
import com.example.demoShop.dto.ManufacturerDTO;
import com.example.demoShop.dto.MaterialDTO;
import com.example.demoShop.dto.ProductDTO;
import com.example.demoShop.dto.SizeDTO;
import com.example.demoShop.dto.TypeDTO;
import com.example.demoShop.services.ProductService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ProductController.class, ProductService.class})
public class ProductControllerTest {
	
	@Autowired
	private ProductController tested;
	
	@MockBean
	private ProductService productService;
	
	private static final Long ID = 12L;
	private ProductDTO productDto;
	
	@Test
	@DisplayName("product by given ID returned successfully")
	public void should_return_productByGivenId_successfully() {
		
		// given
		productDto = getProduct();
		when(productService.findProductById(ID)).thenReturn(productDto);
		
		// when
		ProductDTO actual = tested.findProductById(ID);
		
		// then
		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo(productDto.getName());
		assertThat(actual.getQuantityInStock()).isEqualTo(productDto.getQuantityInStock());
		assertThat(actual.getPrice()).isEqualTo(productDto.getPrice());
		assertThat(actual.getDescription()).isEqualTo(productDto.getDescription());
		assertThat(actual.getCategory()).isEqualTo(productDto.getCategory());
		assertThat(actual.getType()).isEqualTo(productDto.getType());
		assertThat(actual.getManufacturer()).isEqualTo(productDto.getManufacturer());
		assertThat(actual.getSize()).isEqualTo(productDto.getSize());
		assertThat(actual.getColor()).isEqualTo(productDto.getColor());
		assertThat(actual.getMaterials()).isEqualTo(productDto.getMaterials());
		assertThat(actual.getDiscount()).isEqualTo(productDto.getDiscount());
	}
	
	// TODO add more tests!
	
	private ProductDTO getProduct() {
		
		ProductDTO product = new ProductDTO();
		Set<MaterialDTO> materials = new HashSet<>();
		MaterialDTO material1 = new MaterialDTO(1L, "Cotton"); 
		MaterialDTO material2 = new MaterialDTO(2L, "Viscose");
		materials.add(material1);
		materials.add(material2);
		
		product.setId(ID);
		product.setName("T-shirt Lacoste");
		product.setQuantityInStock(5);
		product.setPrice(200.00);
		product.setDescription("T-shirt Lacoste red");
		product.setCategory(new CategoryDTO(2L, "Clothes for men"));
		product.setType(new TypeDTO(4L, "T-shirts"));
		product.setManufacturer(new ManufacturerDTO(6L, "Lacoste"));
		product.setSize(new SizeDTO(2L, "M"));
		product.setColor(new ColorDTO(3L, "Red"));
		product.setMaterials(materials);
		product.setDiscount(new DiscountDTO(2L, 5));
		
		return product;
	}
}
