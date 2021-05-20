package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Instructor {
	
	@Id
	private int instructorcode;
	private String name;
	private int salary;
	private int jobstartyear;
	private String email;
	private String trainerlocation;
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Instructor(int instructorcode, String name, int salary, int jobstartyear, String email,
			String trainerlocation) {
		super();
		this.instructorcode = instructorcode;
		this.name = name;
		this.salary = salary;
		this.jobstartyear = jobstartyear;
		this.email = email;
		this.trainerlocation = trainerlocation;
	}


	public int getInstructorcode() {
		return instructorcode;
	}

	public void setInstructorcode(int instructorcode) {
		this.instructorcode = instructorcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getJobstartyear() {
		return jobstartyear;
	}

	public void setJobstartyear(int jobstartyear) {
		this.jobstartyear = jobstartyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrainerlocation() {
		return trainerlocation;
	}

	public void setTrainerlocation(String trainerlocation) {
		this.trainerlocation = trainerlocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + instructorcode;
		result = prime * result + jobstartyear;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		result = prime * result + ((trainerlocation == null) ? 0 : trainerlocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (instructorcode != other.instructorcode)
			return false;
		if (jobstartyear != other.jobstartyear)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		if (trainerlocation == null) {
			if (other.trainerlocation != null)
				return false;
		} else if (!trainerlocation.equals(other.trainerlocation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instructor [instructorcode=" + instructorcode + ", name=" + name + ", salary=" + salary
				+ ", jobstartyear=" + jobstartyear + ", email=" + email + ", trainerlocation=" + trainerlocation + "]";
	}
	
	
	
	

}
