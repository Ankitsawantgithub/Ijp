package com.practise.pratcise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.pratcise.entity.files;

@Repository
public interface fileRepo extends JpaRepository<files, Long>{

}
