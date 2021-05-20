package com.example.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.beans.Instructor;

@DataJpaTest
class CustomInstructorRepositoryImplTest {

	@Autowired
	InstructorRepository repo;
	
	@Test
	void getInstructorByLocationTest() {
		
		// given 
		System.out.println(" ---->> repo "+repo);
		Instructor instructor1 = new Instructor(101,"A",2000,2008,"a@gmail.com","Delhi");
		Instructor instructor2 = new Instructor(102,"B",3000,2008,"b@gmail.com","Delhi");
		Instructor instructor3 = new Instructor(103,"C",4000,2008,"c@gmail.com","Banglore");
		
		repo.save(instructor1);
		repo.save(instructor2);
		repo.save(instructor3);
		
		// when 
		List<Instructor> list = repo.getInstructorByLocation("Delhi");
		System.out.println("list :- "+list);
		// then 
		
		assertThat(list.size()).isEqualTo(2);
		
	}
	
	

}
