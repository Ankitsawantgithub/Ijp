package com.practise.pratcise.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ankitdetails")
@Data
public class ankitdetails {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	
	private String name ;
	
	private int age ;
	
	private long mobilenumber;

	public ankitdetails(long id, String name, int age, long mobilenumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobilenumber = mobilenumber;
	}

	public ankitdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	
	
	

}
