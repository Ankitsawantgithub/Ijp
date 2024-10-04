package com.practise.pratcise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.pratcise.dto.TransientDto;
import com.practise.pratcise.entity.TransientKeyword;
import com.practise.pratcise.serviceimpl.TransientServiceImpl;

@RestController
@RequestMapping("/transient")
public class TransientController {

	@Autowired
	private TransientServiceImpl transientServiceImpl;

	@PostMapping("/addHere")
	public TransientKeyword createEmployee(@RequestBody TransientKeyword tr) {
		return transientServiceImpl.createEmployee(tr);
	}

//	@GetMapping("/{id}")
//	public TransientDto getData(@PathVariable long id) {
//
//		return transientServiceImpl.getData(id);
//
//	}
	

    @GetMapping("/{id}")
    public ResponseEntity<TransientDto> getData(@PathVariable long id) {
        TransientDto dto = transientServiceImpl.getData(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
