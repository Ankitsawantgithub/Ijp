package com.practise.pratcise.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.pratcise.entity.DocumentsDetails;
import com.practise.pratcise.exception.RecordNotFoundedException;
import com.practise.pratcise.repository.DocumentsRepo;
import com.practise.pratcise.service.DocumentService;

@Service
public class DocumentsServiceImpl implements DocumentService {

	@Autowired
	private DocumentsRepo documentsRepo;

//	@Autowired
//	private RuntimeException runtimeException;

	@Override
	public List<DocumentsDetails> findDoc(boolean status) {

		return documentsRepo.findByStatus(status);
	}

	@Override
	public DocumentsDetails doc(long docId) {
		Optional<DocumentsDetails> docm = documentsRepo.findById(docId);
		if (docm.isPresent()) {
			return docm.get();
		} else {
			return null;
		}
	}

	@Override
	public void addDoc(DocumentsDetails docm) {
		// TODO Auto-generated method stub

		documentsRepo.save(docm);
	}

	@Override
	public void delete(long id) {
		documentsRepo.deleteById(id);

	}

	@Override
	public Map<Boolean, Long> getCountByStatus() {
		List<Object[]> results = documentsRepo.countDocumentsByStatus();
		Map<Boolean, Long> statusCountMap = new HashMap<Boolean, Long>();
		for (Object[] result : results) {
			Boolean status = (Boolean) result[0];
			Long count = (Long) result[1];
			statusCountMap.put(status, count);

		}
		return statusCountMap;
	}

	@Override
	public List<DocumentsDetails> getDataBetween(long start, long end) {
		// TODO Auto-generated method stub

		List<DocumentsDetails> documents = documentsRepo.findadharcardNumberBetween(start, end);
		if (documents.isEmpty()) {
			throw new RecordNotFoundedException("No records found between " + start + " and " + end);
		}

		return documents;

	}
}
