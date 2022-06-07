<%@page import="com.ty.school.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
	<%
	Student student = (Student) request.getAttribute("student");
	%>
	<form action="update">
		Id<input type="text" name="studId" value=<%=student.getId()%> readonly>
		<br>
		<br> Name<input type="text" name="studName"
			value=<%=student.getName()%>> <br>
		<br> Email<input type="text" name="studEmail"
			value=<%=student.getEmail()%>> <br>
		<br> Marks<input type="text" name="studMarks"
			value=<%=student.getMarks()%>> <br>
		<br> Phone<input type="text" name="studPhone"
			value=<%=student.getMobile()%>> <br>
		<br> <input type="submit" value="Save">
	</form>
</body>
</html>