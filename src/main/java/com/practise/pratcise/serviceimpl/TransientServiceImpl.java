package com.practise.pratcise.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.pratcise.dto.TransientDto;
import com.practise.pratcise.entity.TransientKeyword;
import com.practise.pratcise.repository.EmployeeRepo;
import com.practise.pratcise.service.TransientService;

@Service
public class TransientServiceImpl implements TransientService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public TransientKeyword createEmployee(TransientKeyword tr) {
		tr.calculateAnnualSalary();
		return employeeRepo.save(tr);
	}

	@Override
	public TransientDto getData(long id) {
		Optional<TransientKeyword> tr = employeeRepo.findById(id);
		if(tr.isPresent()) {
			
			TransientKeyword emp  =tr.get();
			emp.calculateAnnualSalary();
			
	    TransientDto dtom = new TransientDto(
	    		emp.getId(),
	    		emp.getName(),
	    		emp.getSalary(),
	    		emp.getAnnualSalary()
	    		);
			return dtom;
		}
		return null;
	}

}
