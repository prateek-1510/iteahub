<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="security"  uri = "http://www.springframework.org/security/tags" %>
<html>
<body>
<form:form action="${pageContext.request.contextPath }/logout" method="POST">
<button type="submit">Logout</button>
</form:form>
<br>
<security:authorize access="hasRole('ADMIN') ">
<a href="${pageContext.request.contextPath }/itea-hub-managers-login">Manager Login</a>
</security:authorize>

</body>
</html>