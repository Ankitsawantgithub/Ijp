package com.practise.pratcise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.pratcise.entity.Discount;
import com.practise.pratcise.serviceimpl.DiscountServiceImpl;

@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	private DiscountServiceImpl discountServiceImpl;

	@PostMapping("/addDiscount")
	public Discount addDiscount(@RequestBody Discount discount, @RequestParam double discountRate) {
		return discountServiceImpl.addDiscount(discount, discountRate);
	}
	

}

