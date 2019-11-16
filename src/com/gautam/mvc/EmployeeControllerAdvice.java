package com.gautam.mvc;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gautam.mvc.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvice 
{
    @ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String employeeNotFound(EmployeeNotFoundException e)
	{
		
		return e.toString();
	}
    @ResponseBody
	@ExceptionHandler({SQLException.class,IOException.class})
	public String exception(Exception e)
	{
		return e.getMessage();
	}
}
