package com.practise.pratcise.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.pratcise.entity.Product;
import com.practise.pratcise.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	/**
	 * To find  the all stocck in the databasse
	 * @return
	 */
	@GetMapping("/stock")
	public  int getStockQuantity() {
		return productServiceImpl.getStockQuantity();
	}
	
	@GetMapping("/groupByCategory")
	public Map<String, List<Product>> getProductByCategory(){
		return productServiceImpl.getProductByCategory();
	}

}
