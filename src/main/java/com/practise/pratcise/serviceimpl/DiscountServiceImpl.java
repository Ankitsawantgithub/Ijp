package com.practise.pratcise.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.pratcise.entity.Discount;
import com.practise.pratcise.repository.DiscountRepo;
import com.practise.pratcise.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	private DiscountRepo discountRepo;
	
	@Override
	public Discount addDiscount(Discount discount, double discountRate) {
	// TODO Auto-generated method stub
		discount.calculateDiscountPrice(discountRate);
		return discountRepo.save(discount);
	}
	

}
