package com.example.demo.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Dump;
import com.example.demo.beans.Instructor;

@SpringBootTest
public class MockTestDemoThroughMockito {

	
	@Mock
	Dump dump;
	
	@Test
	@DisplayName("Test to add assert true")
	//@Disabled
	public void doTest()
	{
		String str = "its Very long string";
		// --- check assert true
		//Dump dump = mock(Dump.class);
	/*	
		boolean actual = dump.calculateLongString(str);
		
		assertTrue("This string is not long ",str.length()>10);
		//assertEquals(true, actual);*/
		
		
		when(dump.calculateLongString(str)).thenReturn(true);
		dump.calculateLongString(str);
		verify(dump).calculateLongString(str);
		
		/*
		 * Mockito keep tracks of all the method call , parameters and return values
		 * 
		 * we have to verify the mock object that specific condition are met or not
		 * 
		 * this is call behaviour testing
		 * */
	}
	
	@Test
	@Disabled
	public void checkAssertEquals()
	{
		// calls equals method
		Instructor testObj = new Instructor(101, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		Instructor returnedObj = new Instructor(102, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		
		assertEquals(testObj,returnedObj);
	}
	
	@Test
	@Disabled
	public void checkAssertSame()
	{
		// calls equals method
		Instructor testObj = new Instructor(101, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		Instructor returnedObj = new Instructor(102, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		
		//assertSame("Both Objects are not same ",testObj, returnedObj);
		assertNotSame("Both Objects are same ",testObj, returnedObj);
		
	}
	
	
	@Test
	@Disabled
	public void checkAssertArrayEquals()
	{
		
		int arr1[] = {1,2,3};
		int arr2[] = {1,2,3};
		int arr3[] = {11,22,3};
		
		
		assertArrayEquals("Arrays are not same ",arr1,arr3);
	}
	
	@Test
	@Disabled
	public void checkAssertForListCollection()
	{
		Instructor i1 = new Instructor(101, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		Instructor i2 = new Instructor(102, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		
		List<Instructor> expectedList = new ArrayList<>();
		expectedList.add(i1);
		expectedList.add(i2);
		
		Dump d = new Dump();
		
		assertIterableEquals(expectedList, d.getInstructors());
	}
	
	
	
	@Test
	//@Disabled
	public void checkAssertCharAt()
	{
		
		String str = "This is long String";
		int position = 3;
		
		//Dump d = new Dump();
		//assertEquals('s', d.getCharFromString(str, position));
		
		
		when(dump.getCharFromString(str, position)).thenReturn('s');
		dump.getCharFromString(str, position);
		verify(dump).getCharFromString(str, position);
	}
	
	
	
	@Test
	@Disabled
	public void checkAssertCharAtThrows()
	{
		
		String str = "This is long String";
		int position = 3;
		Dump d = new Dump();
		
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
	       d.getCharFromString(str, -1);
	    });
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
