package com.practise.pratcise.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.practise.pratcise.entity.files;

public interface fileService {
	  public files storeFile(MultipartFile file) throws IOException;
	  
	  public files read(long id);
	  
	   public files downloadFile(long id) throws Exception;

}
