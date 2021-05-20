package com.example.demo.repo;

import java.util.List;

import com.example.demo.beans.Instructor;



public interface CustomInstructorRepository {

	public List<Instructor> getInstructorByLocation(String location);
}
