
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
<title>itea-hub-Login</title>
</head>
<body>
		
	<form:form
		action="${pageContext.request.contextPath}/authenticate-login"
		method="POST">
		<c:if test="${param.error !=null }">
		<i>
		Invalid username or password!
		</i>
		</c:if>
	
		<p>		
			User Name: <input type="text" name="username">
		</p>
		<p>
			Password: <input type="password" name="password">
		</p>
		<br>
		<br>
		<button type="submit" value="Login">Login</button>

	</form:form>

</body>
</html>