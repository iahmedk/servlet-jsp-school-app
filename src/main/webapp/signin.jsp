<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="./homeNavbar.html"></jsp:include>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="./css/signin.css">
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>
	<h2>Sign In form</h2>

	<form action="signin" method="post">
		<div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter email" name="email" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required>

			<button type="submit">SignIn</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>
</body>
</html>