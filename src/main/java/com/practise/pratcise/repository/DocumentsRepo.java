package com.practise.pratcise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practise.pratcise.entity.DocumentsDetails;

@Repository
public interface DocumentsRepo extends JpaRepository<DocumentsDetails, Long> {
	
	public List<DocumentsDetails> findByStatus(@Param("status") boolean status);
	
	 @Query(value = "SELECT * FROM documents WHERE adharcard_holder LIKE %:name%", nativeQuery = true)
	   public List<DocumentsDetails> findByAdharcardHolderContaining(@Param("name") String name);
	 
	 //SELECT * FROM documents WHERE adharcard_holder LIKE '%Doe%';
	 

	    @Query(value = "SELECT status, COUNT(*) as count FROM documents GROUP BY status", nativeQuery = true)
	    List<Object[]> countDocumentsByStatus();
	   // List<Object[]> countDocumentsByStatus();

		@Query(value="select * from documents where adharcard_number between :start and :end",nativeQuery = true)
		public List<DocumentsDetails> findadharcardNumberBetween(@Param("start")long start, @Param("end") long end);

}
