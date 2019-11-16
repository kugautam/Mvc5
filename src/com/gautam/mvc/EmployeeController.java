package com.gautam.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gautam.mvc.Employee;
import com.gautam.mvc.EmployeeNotFoundException;
import com.gautam.mvc.EmployeeController.EmployeeMapper;

@Controller
@RequestMapping("/views")
public class EmployeeController 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;
	private static int empId;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
    @RequestMapping("/registration")
	public String registration(@ModelAttribute("employee") Employee employee)
	{
	   MapSqlParameterSource values = new MapSqlParameterSource();
	   Random random = new Random();
	   int id = random.nextInt(10000)+10000;
	   while(checkEmployee(id))
	   {
        	 id= random.nextInt(10000)+10000;
	   }
	   values.addValue("employeeId", id);
       values.addValue("employeeName", employee.getEmployeeName());
       values.addValue("employeeDepartment", employee.getEmployeeDepartment());
       values.addValue("employeeDesignation",employee.getEmployeeDesignation());
       values.addValue("employeeSalary", employee.getEmployeeSalary());
	   simpleJdbcInsert.execute(values);
	  return "home";
	}
    @ResponseBody
	@RequestMapping("/search")
	public String searchEmployeeById(@RequestParam("employeeId") int employeeId) throws EmployeeNotFoundException
	{     
    	 Employee employee;
    	if(checkEmployee(employeeId))
		 employee = jdbcTemplate.queryForObject("select * from mini.employee where employeeid = "+employeeId, new EmployeeMapper());
    	else
			throw new EmployeeNotFoundException();
		return employee.toString();
	}
    @ResponseBody
    @RequestMapping("/delete")
	public String deleteEmployeeById(@RequestParam("employeeId") int employeeId) throws EmployeeNotFoundException
	{
		if(checkEmployee(employeeId))
			jdbcTemplate.update("delete from mini.employee where employeeid = "+employeeId);
		else
			throw new EmployeeNotFoundException();
		return "<h1>Employee Record Removed<h1>";
	}
    @RequestMapping("/update")
	public ModelAndView update(@RequestParam("employeeId") int  employeeId) throws EmployeeNotFoundException
   	{
    	empId = employeeId;
    	double actualSalary=0;
		if(checkEmployee(employeeId))
			actualSalary=jdbcTemplate.queryForObject("select employeeSalary from mini.employee where employeeId ="+employeeId,Double.class);
		else
			throw new EmployeeNotFoundException();
		return new ModelAndView("updatesalary","salary",actualSalary);
	}
    @ResponseBody
    @RequestMapping("/updateSalary")
    public String updateSalary(@RequestParam("updatedEmployeeSalary") double updatedEmployeeSalary) throws EmployeeNotFoundException
    {
    	jdbcTemplate.update("update mini.employee set employeeSalary=? where employeeId = ?",new Object[]{updatedEmployeeSalary,empId});
		return searchEmployeeById(empId);
    	
    }
    @RequestMapping("/getAllEmployees")
    public ModelAndView allEmployees()
    {
    	return new ModelAndView("allemployees","employees",jdbcTemplate.queryForList("select * from mini.employee"));
    }
    public boolean checkEmployee(int employeeId)
    {
    	if(jdbcTemplate.queryForObject("select count(*) from mini.employee where employeeId="+employeeId,Integer.class)>0)
    		return true;
    	else
    	  return false;
    }
	class EmployeeMapper implements  RowMapper<Employee>
	{
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getInt("employeeId"));
			employee.setEmployeeName(rs.getString("employeeName"));
			employee.setEmployeeDesignation(rs.getString("employeeDesignation"));
			employee.setEmployeeDepartment(rs.getString("employeeDepartment"));
			employee.setEmployeeSalary(rs.getDouble("employeeSalary"));
			return employee;
		}
	}
}

