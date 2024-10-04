package com.practise.pratcise.service;

import java.util.List;
import java.util.Map;

import com.practise.pratcise.entity.Product;

public interface ProductService {
	
	public  int getStockQuantity();
	
	public Map<String, List<Product>> getProductByCategory();

}
