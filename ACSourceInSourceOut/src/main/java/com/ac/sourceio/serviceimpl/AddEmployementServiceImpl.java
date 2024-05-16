package com.ac.sourceio.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac.sourceio.Entity.AddEmployementEntity;
import com.ac.sourceio.Repository.AddEmployementRepo;
import com.ac.sourceio.service.AddEmployementService;

@Service
public class AddEmployementServiceImpl implements AddEmployementService {

	@Autowired
	private AddEmployementRepo addEmployementRepo;
	
	
	
	public AddEmployementServiceImpl(AddEmployementRepo addEmployementRepo) {
		super();
		this.addEmployementRepo = addEmployementRepo;
	}

	@Override
	public AddEmployementEntity createEmployement(AddEmployementEntity aee) {
		addEmployementRepo.save(aee);
		return aee;
	}

	@Override
	public AddEmployementEntity updateEmployement(AddEmployementEntity aee) {
		addEmployementRepo.save(aee);
		return aee;
	}

}
