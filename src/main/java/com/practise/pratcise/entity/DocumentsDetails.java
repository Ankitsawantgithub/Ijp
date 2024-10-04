package com.practise.pratcise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="documents")
@Data
public class DocumentsDetails {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	private String adharcardHolder;
	
	private long adharcardNumber;
	
	private boolean status;

	public DocumentsDetails(long id, String adharcardHolder, long adharcardNumber, boolean status) {
		super();
		this.id = id;
		this.adharcardHolder = adharcardHolder;
		this.adharcardNumber = adharcardNumber;
		this.status = status;
	}

	public DocumentsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
