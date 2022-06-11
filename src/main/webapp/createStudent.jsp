<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./subnavbar.html"></jsp:include>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/signin.css">
<head>
<meta charset="UTF-8">
<title>Create Student</title>
</head>
<body>
	<form action="create">
		Name<input type="text" name="studName"> <br> <br>
		Email<input type="text" name="studEmail"> <br> <br>
		Marks<input type="text" name="studMarks"> <br> <br>
		Phone<input type="text" name="studPhone"> <br>
		<br>
		<div class="container" style="background-color: #f1f1f1">
			<button type="submit" class="create">Save</button>
		</div>
	</form>
</body>
</html>