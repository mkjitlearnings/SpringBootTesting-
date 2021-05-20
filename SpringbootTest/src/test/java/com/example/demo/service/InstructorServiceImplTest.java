package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Closeable;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Instructor;
import com.example.demo.repo.InstructorRepository;

@SpringBootTest
//@DataJpaTest
class InstructorServiceImplTest {

	@Mock
	private InstructorRepository instructorReposiory;
	@InjectMocks
	private InstructorServiceImpl instructorService;
	private AutoCloseable autoClosable;
	
	@BeforeEach
	public void doinit()
	{	
		autoClosable = MockitoAnnotations.openMocks(this);
		instructorService = new InstructorServiceImpl(instructorReposiory);
	}
	@AfterEach
	public void doAtEnd()throws Exception
	{
		autoClosable.close();
	}
	
	@Test
	void testGetAllInstructors() {
		instructorService.getAllInstructors();
		verify(instructorReposiory).findAll();
	}
	
	@Test
	void testAddInstructor() {
		
		Instructor instructorInserted = new Instructor(101, "ramesh", 2000, 2020, "ramesh@gmail.com", "delhi");
		Instructor instructorSaved = new Instructor(101, "ramesh", 2000, 2020, "ramesh@gmail.com", "delhi");
		
		when(instructorReposiory.save(instructorInserted)).thenReturn(instructorSaved);
		instructorService.addInstructor(instructorInserted);
		
		Assertions.assertNotNull(instructorSaved);
        Assertions.assertEquals(instructorInserted, instructorSaved);
		
		verify(instructorReposiory,times(1)).save(instructorSaved);
	}
	



	

}
