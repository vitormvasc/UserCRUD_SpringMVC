<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add new user form</title>
	</head>

	<body>
		<p>Please enter a new user's information</p>
		<form action="addNewUser" method="post"><br>
			Name<input name="name" type="text"><br>
			Login<input name="login" type="text"><br>	
			E-mail<input name="email" type="text"><br>
			Password<input name="password" type="password"><br>
			<button type="submit">Save</button>
			<button>Cancel</button>
			<p> ${mensagem}</p> 
		</form>
	</body>
</html>