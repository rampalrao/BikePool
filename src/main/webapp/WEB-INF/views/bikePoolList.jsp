<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Bike Pool Users Page</title>
</head>
<body>
	<h1>Bike Pool Users Information</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
	Hi ${pageContext.request.userPrincipal.name}<br>

	<c:url var="logoutAction" value="/j_spring_security_logout"></c:url>

	<form action="${logoutAction}" method="post">
		<input type="submit" value="Logout" />
	</form>
	</c:if>
</body>
</html>