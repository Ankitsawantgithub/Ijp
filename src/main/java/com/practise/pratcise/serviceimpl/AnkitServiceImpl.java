package com.practise.pratcise.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.pratcise.entity.ankitdetails;
import com.practise.pratcise.repository.AnkitRepo;
import com.practise.pratcise.service.AnkitService;

@Service
public class AnkitServiceImpl implements AnkitService {

	@Autowired
	private AnkitRepo ankitRepo;

	@Override
	public List<ankitdetails> getAnkitdetails() {

		return ankitRepo.findAll();
	}

	@Override
	public void addData(ankitdetails ankitdetails) {
		ankitRepo.save(ankitdetails);

	}

	@Override
	public ankitdetails getAnkById(long ankId) {
		Optional<ankitdetails> abc = ankitRepo.findById(ankId);
		if (abc.isPresent()) {
			return abc.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateAnk(ankitdetails ank) {
		ankitRepo.save(ank);
		
	}

	@Override
	public void deleteAnk(long id) {
		ankitRepo.deleteById(id);
		
	}

	@Override
	public List<ankitdetails> ankByName(String name) {
		
		return ankitRepo.findByName(name);
	}

	
}
