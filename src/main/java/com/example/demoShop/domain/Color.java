package com.example.demoShop.domain;


import lombok.*;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Color implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "color")
	private List<Product> productsList;

	public Color(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

}
