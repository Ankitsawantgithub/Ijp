package com.practise.pratcise.service;

import java.util.List;
import java.util.Map;

import com.practise.pratcise.entity.DocumentsDetails;
import com.practise.pratcise.exception.RecordNotFoundedException;

public interface DocumentService {
	
	public List<DocumentsDetails> findDoc(boolean status);
	
	public DocumentsDetails doc(long docId);
	
	public void addDoc(DocumentsDetails docm);

	public void delete(long id);
	
	public Map<Boolean, Long> getCountByStatus();
	
	public List<DocumentsDetails> getDataBetween(long start, long end) ;
}
