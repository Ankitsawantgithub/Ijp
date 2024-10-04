package com.practise.pratcise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practise.pratcise.entity.ankitdetails;

@Repository
public interface AnkitRepo extends  JpaRepository<ankitdetails, Long>{
	
	
//	@Query(value ="select * from ankitdetails where name = : name", nativeQuery = true)
//	public List<ankitdetails> findByName(@Param("name") String name);
	
	@Query(value = "select * from ankitdetails where name = :name", nativeQuery = true)
	public List<ankitdetails> findByName(@Param("name") String name);


}