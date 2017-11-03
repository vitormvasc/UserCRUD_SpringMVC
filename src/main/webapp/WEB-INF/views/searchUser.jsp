<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search for an account</title>
	</head>

	<body>
		<p>Please enter the user's credentials:</p>
		<form action="searchUsersForm" method="post"><br>
			Email<input name="email" type="text"><br>
			<button type="submit">Search</button>
			<button>Cancel</button>
			<p> ${mensagem}</p> 
		</form>
	</body>
</html>