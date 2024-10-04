package com.practise.pratcise.dto;

import jakarta.persistence.Transient;

public class TransientDto {

	private long id;
	private String name;

	private double salary;

	private double annualSalary;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public TransientDto(Long id, String name, double salary, double annualSalary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.annualSalary = annualSalary;
	}

	public TransientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
