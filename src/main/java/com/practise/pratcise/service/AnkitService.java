package com.practise.pratcise.service;

import java.util.List;

import com.practise.pratcise.entity.ankitdetails;

public interface AnkitService {
	
	public List<ankitdetails> getAnkitdetails();
	
	public void addData(ankitdetails ankitdetails);
	
	public ankitdetails getAnkById(long ankId);
	
	public void updateAnk(ankitdetails ank);
	
	public  void deleteAnk(long id);
	
	public List<ankitdetails> ankByName(String name);
	
	

}
