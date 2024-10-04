package com.practise.pratcise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.pratcise.entity.TransientKeyword;

@Repository
public interface EmployeeRepo extends JpaRepository<TransientKeyword, Long>{

}
