package com.practise.pratcise.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.pratcise.entity.Product;
import com.practise.pratcise.repository.ProductRepo;
import com.practise.pratcise.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public int getStockQuantity() {

		return productRepo.findAll().stream().mapToInt(Product::getStockQuantity).sum();
	}

	@Override
	public Map<String, List<Product>> getProductByCategory() {

		return productRepo.findAll().stream().collect(Collectors.groupingBy(Product::getCategory));
	}

}
