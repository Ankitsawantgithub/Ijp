package com.practise.pratcise.controller;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practise.pratcise.entity.files;
import com.practise.pratcise.serviceimpl.fileServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
public class FileController {
	@Autowired
	private fileServiceImpl flServiceImpl;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
		}

		try {
			files savedFiles = flServiceImpl.storeFile(file);
			return ResponseEntity.ok("file uploaded succesfully :" + savedFiles.getFileName());
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error uploading file: " + e.getMessage());
		}
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<files> read(@PathVariable long id) {

		files fl = flServiceImpl.read(id);
		if (fl != null) {
			return new ResponseEntity<files>(fl, HttpStatus.OK);
		} else {
			return new ResponseEntity("File not  present ", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/download/{id}")
	    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
	    	
	    	 try {
	             files fileEntity = flServiceImpl.downloadFile(id);
	             
	             Map<String, String> headers = new HashMap<>();
	             headers.put("Content-Disposition", "attachment; filename=\"" + fileEntity.getFileName() + "\"");

	             return ResponseEntity.ok()
	                     .headers(new org.springframework.http.HttpHeaders())
	                     .body(fileEntity.getData());
	         } catch (Exception e) {
	             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	         }
	    }
	    
	    
	    
}
