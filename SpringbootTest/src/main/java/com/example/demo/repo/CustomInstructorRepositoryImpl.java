package com.example.demo.repo;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomInstructorRepositoryImpl implements CustomInstructorRepository
{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<com.example.demo.beans.Instructor> getInstructorByLocation(String location) {
		Session session = entityManager.unwrap(Session.class);// connection
		// JPQL :- same like SQL but for Java Developers
		
		Query<com.example.demo.beans.Instructor> query = 
				session.createQuery("from Instructor where trainerlocation = '"+location+"'");
		// query fire over table
		return query.getResultList(); // convert result into List<String>
	}

	
}
