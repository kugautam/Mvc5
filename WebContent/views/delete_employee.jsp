<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="delete" method="post">
<table>
 <tr>
 <th>Enter the Employee id</th>
 <th>:</th>
 <th><input type="number" required="required" name="employeeId" pattern="[0-9]{5}"></th>
 </tr>
 
 <tr>
 <th></th>
 <th></th>
 <th><input type="submit" ></th>
  </tr>

</table>
</form>
</body>
</html>