package com.gautam.mvc;

public class EmployeeNotFoundException extends Exception 
{

	@Override
	public String toString() {
		return "Employee Record Not Found";
	}
      
}
