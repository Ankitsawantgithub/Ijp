package com.practise.pratcise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "discount")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	
	
	@Transient
	private transient double DiscountPrice;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getDiscountPrice() {
		return DiscountPrice;
	}


	public void setDiscountPrice(double discountPrice) {
		DiscountPrice = discountPrice;
	}
	
	public void calculateDiscountPrice(double discountRate) {
		this.DiscountPrice = this.price * (1- discountRate);
	}
	
	

}
