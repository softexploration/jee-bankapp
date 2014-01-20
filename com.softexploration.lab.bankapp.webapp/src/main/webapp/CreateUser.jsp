<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new user</title>
</head>
<body>

	<h1>Create new user</h1>
	<form action="CreateUserRequest" method="post">
		<h2>User data</h2>
		name1: <input type="text" name="name1" /> <br />
		name2: <input type="text" name="name2" /> <br />
		userStatus: <input type="text" name="userStatus" /> <br />
		<h2>Address 1</h2>
		Region: <input type="text" name="address1Region" /> <br />
		Country: <input type="text" name="address1Country" /> <br />
		City: <input type="text" name="address1City" /> <br />
		Zip: <input type="text" name="address1Zip" /> <br />
		Street: <input type="text" name="address1Street" /> <br />
		<br/>
		<h2>Address 2</h2>
		Region: <input type="text" name="address2Region" /> <br />
		Country: <input type="text" name="address2Country" /> <br />
		City: <input type="text" name="address2City" /> <br />
		Zip: <input type="text" name="address2Zip" /> <br />
		Street: <input type="text" name="address2Street" /> <br />
		
		<button type="submit" name="createUserSubmit" value="create">create</button>
	</form>

</body>
</html>