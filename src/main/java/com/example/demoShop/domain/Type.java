package com.example.demoShop.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Type implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Transient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
	private List<Product> productsList;

	public Type(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
