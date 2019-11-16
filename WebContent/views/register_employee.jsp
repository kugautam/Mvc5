<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registration" method="post">
<table>
 <tr>
 <th>Enter the Employee Name</th>
 <th>:</th>
 <th><input type="text" required="required" name="employeeName"></th>
 </tr>
 <tr>
 <th>Enter the Employee Department</th>
 <th>:</th>
 <th>
 <select id="employeeDepartment" name="employeeDepartment" required="required">
 <option  selected value="HR">HR
 <option value="Accounts">Accounts
 <option value="Sales">Sales
 </select>
 </th>
 </tr>
 <tr>
 <th>Enter the Employee Designation</th>
 <th>:</th>
 <th><input type="text" required="required" name="employeeDesignation"></th>
 </tr>
 <tr>
 <th>Enter the Employee Salary</th>
 <th>:</th>
 <th><input type="number" required="required" name="employeeSalary" pattern="[0-9]{8}"></th>
 </tr>
 <tr>
 <th></th>
 <th></th>
 <th><input type="submit" > </tr>

</table>

</form>
</body>
</html>