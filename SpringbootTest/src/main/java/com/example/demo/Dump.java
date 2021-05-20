package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.beans.Instructor;

public class Dump {
	
	public boolean calculateLongString(String str)
	{
		char arr[] = str.toCharArray();
		int count = 0;
		
		for (char c : arr) {
			count++;
		}
		
		if(count>10) return true;
		else return false;
	}
	
	public List<Instructor> getInstructors()
	{
		Instructor i1 = new Instructor(101, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		Instructor i2 = new Instructor(102, "Ramesh", 2000, 2020, "ramesh@gmail.com", "New Delhi");
		
		return new ArrayList<Instructor>(Arrays.asList(i1,i2));		
	}
	
	public char getCharFromString(String str,int position)throws StringIndexOutOfBoundsException
	{
		if(str.length()<position || position<0)
		{
			throw new StringIndexOutOfBoundsException(str+" and "+position+" are missed match");
		}
		else
			return str.charAt(position);
		
	}
}
