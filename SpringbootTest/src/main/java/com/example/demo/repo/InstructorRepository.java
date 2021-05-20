package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Instructor;



public interface InstructorRepository extends 
	JpaRepository<Instructor, Integer>, 
	CustomInstructorRepository
{
  /*
   * 1) All JPA Methods
   * 2) All Custom Instructor 
   * */
}
