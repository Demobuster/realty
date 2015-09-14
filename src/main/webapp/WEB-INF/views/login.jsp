<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="msg" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://images.akamai.steamusercontent.com/ugc/534009924279689988/BFE1433020371ED995DF224B54F8C13CBF8F3767/" />
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- signin.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puYzMwQ016VmhHNXc" rel="stylesheet" />
<!-- validate.js -->
<script type='text/javascript' src="https://googledrive.com/host/0BweevD4Le1puNng4V1Q0a3FOczQ"></script>

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<title>Login Page</title>

</head>
<body>
	<msg:message code="Login.loginButton" var="login"/>
	<msg:message code="Login.homeButton" var="home"/>
	<msg:message code="Login.registerLink" var="register"/>
	<msg:message code="Login.welcome1Line" var="welcome1"/>
	<msg:message code="Login.welcome2Line" var="welcome2"/>
	<msg:message code="Login.usernamePlaceholder" var="usernamePlaceholder"/>
	<msg:message code="Login.passwordPlaceholder" var="passwordPlaceholder"/>


	<div class="container">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' class="form-signin"
			action="<c:url value='/j_spring_security_check' />" method='POST'>
			<h2 class="featurette-heading">
				${ welcome1 }<br><span class="text-muted">${ welcome2 }</span>
			</h2>

			<label for="inputEmail" class="sr-only">Username</label>
			<input type="text" name="username" placeholder="${ usernamePlaceholder }"
			  id="inputEmail" class="form-control" onchange="validateUsername()">
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="password" placeholder="${ passwordPlaceholder }" 
				id="inputPassword" class="form-control" onchange="validatePassword()"> 
			<input type="hidden" name="enabled" value="1"> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<button class="btn btn-lg btn-primary btn-block" type="submit">${ login }</button>

		</form>
		<a href="registration">${ register }</a>
	</div>
	
	<jsp:include page="footer.jsp">
		<jsp:param name="linkToReturnTo" value="${ home }"/>
        <jsp:param name="pageToReturnTo" value="welcome"/>
    </jsp:include>
	
</body>
</html>