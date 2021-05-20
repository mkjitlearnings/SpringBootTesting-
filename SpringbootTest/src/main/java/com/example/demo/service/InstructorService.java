package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.beans.Instructor;



public interface InstructorService {

	public List<Instructor> getAllInstructors();
	
	public List<Instructor> getAllInstructorsbyExp();
	
	@Query("From Instructor order by salary ASC")
	public List<Instructor> getAllInstructorsbySalary();
	
	public Instructor getInstructorById(int searchId)throws ResponseStatusException;
	
	public List<Instructor> getAllInstructorsbyLocation(String location);
	
	public Instructor addInstructor(Instructor instructor);
	
	public Instructor updateInstructor(int id,String newLocation);
	
	
}
