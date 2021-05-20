package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.beans.Instructor;
import com.example.demo.repo.InstructorRepository;



@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	private InstructorRepository repo;
	
	public InstructorServiceImpl() {
		
	}

	public InstructorServiceImpl(InstructorRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Instructor> getAllInstructors() {
		return repo.findAll();  // method implemented by JPA Internally
	}

	@Override
	public List<Instructor> getAllInstructorsbyExp() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("jobstartyear").ascending());
	}

	@Override
	public List<Instructor> getAllInstructorsbySalary() {
		return repo.findAll();
	}
	
	@Override
	public List<Instructor> getAllInstructorsbyLocation(String location) {
		
		return repo.getInstructorByLocation(location);
		
	}

	@Override
	@Transactional
	public Instructor addInstructor(Instructor instructor) {
	
		repo.save(instructor);
		return instructor;
	}

	@Override
	@Transactional
	public Instructor updateInstructor(int id,String newLocation) {
		
		Instructor searchedinstructor = repo.findById(id).get();
		
		searchedinstructor.setTrainerlocation(newLocation);
		
		return addInstructor(searchedinstructor);
	}

	@Override
	public Instructor getInstructorById(int searchId) throws ResponseStatusException {
		
		return repo.findById(searchId).get(); // get becoz it return optional<>
	}
	
	
	
	
	
	
	
}











