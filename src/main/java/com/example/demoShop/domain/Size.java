package com.example.demoShop.domain;


import lombok.*;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Size implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Transient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "size", fetch = FetchType.LAZY)
	private List<Product> productsList;

	public Size(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
