package com.practise.pratcise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.pratcise.entity.ankitdetails;
import com.practise.pratcise.repository.AnkitRepo;
import com.practise.pratcise.serviceimpl.AnkitServiceImpl;

@RestController
@RequestMapping("/ank")
public class AnkitController {

	@Autowired
	private AnkitServiceImpl ankitServiceImpl;

	@Autowired
	private AnkitRepo ankitRepo;

	@GetMapping("/details")
	public ResponseEntity<List<ankitdetails>> getDetails() {

		List<ankitdetails> ankData = ankitServiceImpl.getAnkitdetails();
		return new ResponseEntity<List<ankitdetails>>(ankData, HttpStatus.OK);

	}

	@PostMapping("/insert")
	public ResponseEntity<String> addData(@RequestBody ankitdetails ankitdetails) {
		ankitServiceImpl.addData(ankitdetails);
		return new ResponseEntity<String>("Data saved into  the DATABASE", HttpStatus.OK);

	}

	@GetMapping("/getById/{ankId}")
	public ResponseEntity<ankitdetails> getAnkById(@PathVariable long ankId) {
		ankitdetails ank = ankitServiceImpl.getAnkById(ankId);
		if (ank != null) {
			return new ResponseEntity<ankitdetails>(ank, HttpStatus.OK);
		} else {
			return new ResponseEntity("THis id is  not presented", HttpStatus.ACCEPTED);
		}
	}

	@PutMapping("/put")
	public ResponseEntity<String> updateAnk(@RequestBody ankitdetails ank) {
		ankitServiceImpl.updateAnk(ank); 
		return new ResponseEntity<String>("This  is  updated", HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAnk(@RequestParam long id) {

		if (!ankitRepo.existsById(id)) {
			return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
		} else {
			ankitServiceImpl.deleteAnk(id);

			return new ResponseEntity<String>("This  is deleted", HttpStatus.OK);
		}

	}

	@GetMapping("/byname/{name}")
	public ResponseEntity<List<ankitdetails>> ankByName(@PathVariable String name) {
		List<ankitdetails> ank = ankitServiceImpl.ankByName(name);
		if (ank != null && !ank.isEmpty()) {
			return new ResponseEntity<List<ankitdetails>>(ank, HttpStatus.OK);
		} else {
			return new ResponseEntity("this   is  not available", HttpStatus.BAD_GATEWAY);
		}

	}

}
