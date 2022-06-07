<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.school.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student</title>
<!-- <link rel="stylesheet" type="text/css" href="login.css"/> -->
</head>
<body>
	<table border="2px" cellpadding=2px>
		<tr>
			<th>Name</th>
			<th>Id</th>
			<th>Marks</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		List<Student> list = (ArrayList<Student>) request.getAttribute("students");
		for (Student student : list) {
		%>
		<tr>
			<td><%=student.getName()%></td>
			<td><%=student.getId()%></td>
			<td><%=student.getMarks()%></td>
			<td><%=student.getMobile()%></td>
			<td><%=student.getEmail()%></td>
			<td><a href="edit?id=<%=student.getId()%>">Edit</a></td>
			<td><a href="delete?id=<%=student.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
		<tr>
	</table>

</body>
</html>