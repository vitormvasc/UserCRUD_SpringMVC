<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Close my account</title>
	</head>

	<body>
		<p>Please confirm your credentials to close your account</p>
		<form action="deleteGivenUser" method="post"><br>
			Email<input name="email" type="text"><br>
			Password<input name="password" type="password"><br>
			<button type="submit">Remove</button>
			<button>Cancel</button>
			<p> ${mensagem}</p> 
		</form>
	</body>
</html>