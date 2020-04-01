package com.example.demoShop.services_impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demoShop.domain.Category;
import com.example.demoShop.domain.Color;
import com.example.demoShop.domain.Discount;
import com.example.demoShop.domain.Manufacturer;
import com.example.demoShop.domain.Material;
import com.example.demoShop.domain.Product;
import com.example.demoShop.domain.Size;
import com.example.demoShop.domain.Type;
import com.example.demoShop.dto.CategoryDTO;
import com.example.demoShop.dto.ColorDTO;
import com.example.demoShop.dto.DiscountDTO;
import com.example.demoShop.dto.ManufacturerDTO;
import com.example.demoShop.dto.MaterialDTO;
import com.example.demoShop.dto.ProductDTO;
import com.example.demoShop.dto.SizeDTO;
import com.example.demoShop.dto.TypeDTO;
import com.example.demoShop.repositories.ProductRepository;
import com.example.demoShop.services.ProductService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	@Override
	public ProductDTO findProductById(Long id) {
		
		Optional<Product> optionalProduct = productRepository.findById(id);
		Product product = optionalProduct.get();
		
		Set<Material> materials = product.getMaterials();
		Set<MaterialDTO> materialsDTO = new HashSet<>();
		for(Material material : materials) {
			materialsDTO.add(new MaterialDTO(material.getId(), material.getName()));
		}
		
		ProductDTO productDTO = new ProductDTO(
				product.getId(),
				product.getName(),
				product.getQuantityInStock(),
				product.getPrice(),
				product.getDescription(),
				
				new CategoryDTO(product.getCategory().getId(), product.getCategory().getName()),
				new TypeDTO(product.getType().getId(), product.getType().getName()),
				new ManufacturerDTO(product.getManufacturer().getId(), product.getManufacturer().getName()),
				new SizeDTO(product.getSize().getId(), product.getSize().getName()),
				new ColorDTO(product.getColor().getId(), product.getColor().getName()),
				
				materialsDTO,
				
				new DiscountDTO(product.getDiscount().getId(), product.getDiscount().getDiscountValue())
				);
		
		return productDTO;
	}

	@Override
	public List<ProductDTO> findAllProducts() {
		
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		List<Product> productList = productRepository.findAll();
		
		for (Product product : productList) {
			
			Set<Material> materials = product.getMaterials();
			Set<MaterialDTO> materialsDTO = new HashSet<>();
			for(Material material : materials) {
				materialsDTO.add(new MaterialDTO(material.getId(), material.getName()));
			}
			ProductDTO productDTO = new ProductDTO(
					product.getId(),
					product.getName(),
					product.getQuantityInStock(),
					product.getPrice(),
					product.getDescription(),
					
					new CategoryDTO(product.getCategory().getId(), product.getCategory().getName()),
					new TypeDTO(product.getType().getId(), product.getType().getName()),
					new ManufacturerDTO(product.getManufacturer().getId(), product.getManufacturer().getName()),
					new SizeDTO(product.getSize().getId(), product.getSize().getName()),
					new ColorDTO(product.getColor().getId(), product.getColor().getName()),
					
					materialsDTO,
					
					new DiscountDTO(product.getDiscount().getId(), product.getDiscount().getDiscountValue()));
			
			productDTOs.add(productDTO);
			}
		
		return productDTOs;
	}

	@Override
	public void saveProduct(ProductDTO productDTO) {
		
		Set<MaterialDTO> materialDTOs = productDTO.getMaterials();
		Set<Material> materials = new HashSet<>();
		for(MaterialDTO materialDTO : materialDTOs) {
			materials.add(new Material(materialDTO.getId(), materialDTO.getName()));
		}
		
		
		Product product = new Product(
				productDTO.getId(),
				productDTO.getName(),
				productDTO.getQuantityInStock(),
				productDTO.getPrice(),
				productDTO.getDescription(),
				
				new Category(productDTO.getCategory().getId(), productDTO.getCategory().getName()),
				new Type(productDTO.getType().getId(), productDTO.getType().getName()),
				new Manufacturer(productDTO.getManufacturer().getId(), productDTO.getManufacturer().getName()),
				new Size(productDTO.getSize().getId(), productDTO.getSize().getName()),
				new Color(productDTO.getColor().getId(), productDTO.getColor().getName()),
				
				materials,
				
				new Discount(productDTO.getDiscount().getId(), productDTO.getDiscount().getDiscountValue())
				);
		
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}

}
