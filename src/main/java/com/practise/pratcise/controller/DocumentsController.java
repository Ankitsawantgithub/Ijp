package com.practise.pratcise.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practise.pratcise.entity.DocumentsDetails;
import com.practise.pratcise.exception.RecordNotFoundedException;
import com.practise.pratcise.repository.DocumentsRepo;
import com.practise.pratcise.serviceimpl.DocumentsServiceImpl;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

	@Autowired
	private DocumentsServiceImpl documentsServiceImpl;

	@Autowired
	private DocumentsRepo documentsRepo;

	/**
	 * This api gives the status of the current employeee
	 * 
	 * @param status
	 * @return
	 */
	@GetMapping("/status")
	public ResponseEntity<List<DocumentsDetails>> findDoc(@RequestParam boolean status) {
		List<DocumentsDetails> doc = documentsServiceImpl.findDoc(status);
		return new ResponseEntity<List<DocumentsDetails>>(doc, HttpStatus.OK);

	}

	/**
	 * This api is for to find the id
	 * 
	 * @param docId
	 * @return
	 */

	@GetMapping("/{docId}")
	public ResponseEntity<DocumentsDetails> doc(@PathVariable long docId) {
		DocumentsDetails docm = documentsServiceImpl.doc(docId);
		if (docm != null) {
			return new ResponseEntity<DocumentsDetails>(docm, HttpStatus.OK);
		} else {
			return new ResponseEntity("This id is  not present", HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * we adding data from this api
	 * 
	 * @param docm
	 * @return
	 */
	@PostMapping("/inserthere")
	public ResponseEntity<String> addDoc(@RequestBody DocumentsDetails docm) {
		documentsServiceImpl.addDoc(docm);
		return new ResponseEntity<String>("Data is inserted", HttpStatus.OK);
	}

	/**
	 * we delete records from this api
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam long id) {

		if (documentsRepo.existsById(id)) {
			documentsServiceImpl.delete(id);
			return new ResponseEntity<String>("Record deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("record not founded", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * when we have to find status by its count
	 * 
	 * @return
	 */
	@GetMapping("/count")
	public Map<Boolean, Long> getCountByStatus() {
		return documentsServiceImpl.getCountByStatus();
	}

	@GetMapping("/between")
	public ResponseEntity<List<DocumentsDetails>> getDataBetween(@RequestParam long start, @RequestParam long end) {
		try {
	        List<DocumentsDetails> doc = documentsServiceImpl.getDataBetween(start, end);
	        return new ResponseEntity<>(doc, HttpStatus.OK);
	    } catch (RecordNotFoundedException e) {
	        // Return a response entity with the exception message and NOT_FOUND status
	        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	    }

	}
	

//    @ExceptionHandler(RecordNotFoundedException.class)
//    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundedException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }

}
