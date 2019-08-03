<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		Country: <form:select path="country">
					<form:options items="${theCountryOptions}" />				
				</form:select>	
				
		<br><br>	
		
		Favorite language: Java <form:radiobutton path="favoriteLanguage" value="Java" />
							Python <form:radiobutton path="favoriteLanguage" value="Python" />
							JavaScript <form:radiobutton path="favoriteLanguage" value="JavaScript" />
		
		<br><br>
		
		Operating systems: Linux <form:checkbox path="operatingSystems" value="Linux" />
							Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
							Windows <form:checkbox path="operatingSystems" value="Windows" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	
	</form:form>

</body>
</html>