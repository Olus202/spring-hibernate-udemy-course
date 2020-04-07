<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

	<title>luv2code Start Page</title>

</head>
<body>
	<h2>luv2code Start Page</h2>
	<hr>
	<p>
	Welcome in my very first Spring Security App
	</p>
	
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		
		<input type="submit" value="Logout" />
	</form:form>
	
</body>

</html>