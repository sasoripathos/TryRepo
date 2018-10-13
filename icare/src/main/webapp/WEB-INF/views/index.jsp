<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			iCare
		</title>
	</head>
	<body>
		<h2>Hello World!</h2>
		<p>Welcome to iCare, please login.</p>
		<form:form action="/login" method="POST" modelAttribute="loginUser">
			Email: <form:input path="email" placeholder="please enter your username"/>
			<br><br>
			Password: <form:input type="password" path="password" placeholder="Please enter your password"/>
			<br><br>
			<input type="submit" value="submit"/>
		</form:form>
	</body>
</html>
