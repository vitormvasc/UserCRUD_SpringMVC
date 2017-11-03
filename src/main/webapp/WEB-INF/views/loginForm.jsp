<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Form</title>
	</head>

	<body>
		<p>Please enter your credentials</p>
		<form action="login" method="post"><br>
			E-mail<input name="email" type="text"><br>
			Password<input name="password" type="password"><br>
			<button type="submit">Login</button>
			<button>Cancel</button>
			<p> ${mensagem}</p> 
		</form>
	</body>
</html>