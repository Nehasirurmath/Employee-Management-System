<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>

</head>
<body style=background:#016A70>
<p>
	<h1 style="text-align: center;">SignUp</h1>
	</p>
	<form action="EmployeeController" method="post" align="center">
	<hr>
		<input type="hidden" name="action" value="signup"> 
		<label><b>Enter UserId<b></label> 
		<input type="text" name="empid" placeholder="Enter UserId"><br>
		<label><b>Enter UserName<b></label> 
		<input type="text" name="empname" placeholder="Enter UserName"><br>
		<label><b>Enter UserAddress<b></label> 
		<input type="text" name="empaddress" placeholder="Enter UserAddress"><br>
		<label><b>Enter UserState<b></label>
		<select name="userstate" >
		<option value="MH">Maharashtra</option> 
		<option value="KA">Karnataka</option> 
		<option value="GJ">Gujrat</option>
		<option value="GA">Goa</option> 
		<option value="PJ">Punjab</option> 
		<option value="AS">Assam</option> 
		<option value="KL">Kerela</option> 
		<option value="MP">Madhya Pradesh</option>  
		</select> 
		<br>
		<label><b>Enter UserSalary<b></label> 
		<input type="text" name="empsalary" placeholder="Enter UserSalary"><br>
		<label><b>Enter UserContactNumber<b></label> 
		<input type="text" name="empcontactnumber" placeholder="Enter UserContactNumber"><br>
		<label><b>Enter UserGender<b></label>
        
		Male<input type="radio" name="empgender" value="male">
		Female<input type="radio" name="empgender" value="Female">
		<br>
		<label><b>Enter UserDept<b></label> 
		HR<input type="checkbox" name="empdept" value="HR" ><br>
		Finance<input type="checkbox" name="empdept" value="Finance"><br>
		R&D<input type="checkbox" name="empdept" value="R&D"><br>
		Production<input type="checkbox" name="empdept" value="Production"><br>
		QA<input type="checkbox" name="empdept" value="QA"><br>
		
		<label><b>Enter UserDOB<b></label> 
		<input type="Date" name="empdob" placeholder="Enter UserDOB"><br>
		<label><b>Enter UserUID<b></label> 
		<input type="text" name="empuid" placeholder="Enter UserUID"><br>
		<label><b>Enter UserPanCard<b></label> 
		<input type="text" name="emppancard" placeholder="Enter UserPanCard"><br>
		<label><b>Enter UserEmailId<b></label> 
		<input type="email" name="empemailid" placeholder="Enter UserEmailId"><br>
		<label><b>Enter UserPassword<b></label> 
		<input type="password" name="emppassword" placeholder="Enter UserAddress"><br>
		<input type="submit" name="signup" value="signup">
	</form>

</body>
</html>