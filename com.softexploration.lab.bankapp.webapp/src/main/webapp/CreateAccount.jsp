<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new account</title>
</head>
<body>

	<h1>Create new account</h1>
	<form action="CreateAccountRequest" method="post">
		<h2>Account data</h2>
		number: <input type="text" name="number" /> <br />
		name1: <input type="text" name="name1" /> <br />
		userId: <input type="text" name="userId" /> <br />
		<button type="submit" name="createAccountSubmit" value="create">create</button>
	</form>

</body>
</html>