package com.practise.pratcise.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="files")
public class files {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column( unique = true)
    private String fileName;
    private String fileType;
    
    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public files(String fileName, String fileType, byte[] data) {
		super();
		
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public files() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
