<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
	
	<p>
	User: <security:authentication property="principal.username"/>
	<br>
	<br>
	Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	<a href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a> 
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/systems">Admin Stuff</a> 
	</security:authorize>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		
		<input type="submit" value="Logout" />
	</form:form>
	
</body>

</html>