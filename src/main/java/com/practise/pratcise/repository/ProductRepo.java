package com.practise.pratcise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.pratcise.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
