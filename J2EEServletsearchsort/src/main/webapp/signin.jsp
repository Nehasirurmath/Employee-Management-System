<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>SignIn</title>
<style type="text/css">
body {

    justify-content:center;
	background:#A2C579;
	margin: 0;
}
</style>
</head>
<body>
<%
if(request.getAttribute("message")!=null){
	out.println(request.getAttribute("message"));
}
%>
	<p>
	<h1 style="text-align: center;">SignIn</h1>
	</p>
	<hr>
	<form action="EmployeeController" method="post" align="center">
	
		<input type="hidden" name="action" value="signin"> 
		
		<label><b>Enter UserEmailId<b></label> 
		<input type="email" name="empemailid" placeholder="Enter UserEmailId"><br>
		
		<label><b>Enter UserPassword<b></label> 
		<input type="password" name="emppassword" placeholder="Enter UserAddress"><br>
		
		<input type="submit" name="signin" value="signin">
	</form>


</body>
</html>