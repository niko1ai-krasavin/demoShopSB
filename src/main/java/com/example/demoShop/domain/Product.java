package com.example.demoShop.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Integer quantityInStock;
	
	private Double price;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.ALL
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.ALL
	@JoinColumn(name = "type_id", nullable = false)
	private Type type;
	
	@ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.ALL
	@JoinColumn(name = "manufacturer_id", nullable = false)
	private Manufacturer manufacturer;
	
	@ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.ALL
	@JoinColumn(name = "size_id", nullable = false)
	private Size size;
	
	@ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.ALL
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "products_materials",
		    joinColumns = @JoinColumn(name = "product_id"),
		    inverseJoinColumns = @JoinColumn(name = "material_id")
		)
	private Set<Material> materials = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY) //, cascade = CascadeType.ALL
	@JoinColumn(name = "discount_id", nullable = false)
	private Discount discount;

	
	
}
