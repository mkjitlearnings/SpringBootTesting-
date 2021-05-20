package com.example.demo.web;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.beans.Instructor;
import com.example.demo.service.InstructorService;



@RestController
public class InstructorRestController {

	private static final Logger logger = LoggerFactory.getLogger(InstructorRestController.class);
	
	
	@Autowired			// Apprach based on Spring JPA Data
	private InstructorService insService;
	
	
	public InstructorRestController() {
		super();
		System.out.println("========>> Rest Controller Constructor ");
	}
	
	
	@GetMapping("/jpa/trainers")
	public List<Instructor> getAllInstructorsThroughJPAData()
	{
		logger.info("inside getAllInstructor through JPA Data ");
		return insService.getAllInstructors();
	}
	
	@GetMapping("/jpa/trainers/exp")
	public List<Instructor> getAllInstructorsThroughJPAData2()
	{
		return insService.getAllInstructorsbyExp();
	}
	
	@GetMapping("/jpa/trainers/location/{location}")
	public List<Instructor> getAllInstructorsThroughJPAData3(@PathVariable String location)
	{
		return insService.getAllInstructorsbyLocation(location); // this is the method from custom repo.
	}
	
	@GetMapping("/jpa/trainer/{id}")
	public Instructor getAllInstructorsInfoByJPARepo(@PathVariable int id)
	{
		Instructor instructor =  insService.getInstructorById(id);
		if(instructor != null) return instructor;
		else throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Instructor assigned to Instructor Code "+id);
		
	}
	
	
	@PostMapping("/jpa/trainer")
	public Instructor saveInstructor(@RequestBody Instructor instructor)
	{
		return insService.addInstructor(instructor);		
	}
	
	
	@PutMapping("/jpa/trainer/{id}/location/{newlocation}")
	public ResponseEntity<Instructor> updateLocation(@PathVariable int id,@PathVariable String newlocation)
	{
		Instructor updatedInstructor = insService.updateInstructor(id, newlocation);
		System.out.println(" ----->> Inside updateLocation "+updatedInstructor);
		return ResponseEntity.ok(updatedInstructor);
	}
	
	@GetMapping("/jpa/test")
	public String doThis()
	{
		return "Test -api";
	}


	

	
	

	
	
}//end class



















