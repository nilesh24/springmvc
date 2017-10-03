<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/springmvc/mvc/processAddUser" method="post">
<h1>Add User form</h1>

Add User name :: <input type="text" name="name" > <p/>
Enter Age  :: <input type="text" name="age" > <p/>

Enter Address

Line1 :  <input type="text" name="line1" > <p/>
Line 2 <input type="text" name="line2" > <p/>
City : <input type="text" name="city" > <p/>
Submit :: <input type="submit" name="submit" > <p/>




</form>

</body>
</html>