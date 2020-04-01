package com.example.demoShop.domain;


import java.io.Serializable;

import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orderuser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String paymentMethod;
	
	private String deliveryMethod;
	
	private String paymentState;
	
	private String orderStatus;
}
