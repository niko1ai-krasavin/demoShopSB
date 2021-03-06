package com.example.demoShop.domain;


import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Manufacturer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Transient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer", fetch = FetchType.LAZY)
	private List<Product> productsList;

	public Manufacturer(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

}
