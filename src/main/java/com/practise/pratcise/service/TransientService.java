package com.practise.pratcise.service;

import com.practise.pratcise.dto.TransientDto;
import com.practise.pratcise.entity.TransientKeyword;

public interface TransientService {
	
	public TransientKeyword createEmployee(TransientKeyword tr);

	public TransientDto getData(long id);
}
