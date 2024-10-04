package com.practise.pratcise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.pratcise.entity.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long>{

}
