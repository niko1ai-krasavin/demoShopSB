package com.example.demoShop.domain;



import lombok.*;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Discount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer discountValue;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "discount")
	private List<Product> productsList;

	public Discount(Long id, Integer discountValue) {
		this.id = id;
		this.discountValue = discountValue;
	}
	
	

}
