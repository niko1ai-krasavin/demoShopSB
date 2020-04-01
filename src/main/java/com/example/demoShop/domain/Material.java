package com.example.demoShop.domain;


import lombok.*;
import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
public class Material implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Transient
	@ManyToMany(mappedBy = "materials", fetch = FetchType.LAZY)
	private Set<Product> products = new HashSet<>();

	public Material(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
}
