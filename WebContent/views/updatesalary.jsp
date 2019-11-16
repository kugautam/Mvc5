<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="updateSalary">
 <table>
 <tr>
 <th>Update the salary</th>
 <th>:</th>
 <th><input type="number" required="required" name="updatedEmployeeSalary" pattern="[0-9]{7}" value="${salary}" ></th>
 </tr>
 
 <tr>
 <th></th>
 <th></th>
 <th><input type="submit" >${actualSalary}</th>
  </tr>

</table>
  
 </form>
</body>
</html>