<%@ page session="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="msg"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="http://images.akamai.steamusercontent.com/ugc/534009924279689988/BFE1433020371ED995DF224B54F8C13CBF8F3767/" />
<title>Registration Page</title>
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- signin.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puYzMwQ016VmhHNXc"	rel="stylesheet" />
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc"	rel="stylesheet">
<!-- jQuery -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- validate.js -->
<script src="https://googledrive.com/host/0BweevD4Le1puNng4V1Q0a3FOczQ" type='text/javascript'></script>
</head>

<body>

	<msg:message code="Signup.signupButton" var="signup" />
	<msg:message code="Signup.homeButton" var="home" />
	<msg:message code="Signup.welcome1Line" var="welcome1" />
	<msg:message code="Signup.welcome2Line" var="welcome2" />
	<msg:message code="Signup.minimumChars" var="minimumChars" />
	<msg:message code="Signup.confirmPassword" var="confirmPassword" />
	<msg:message code="Signup.dontMatch" var="dontMatch" />
	<msg:message code="Login.usernamePlaceholder" var="usernamePlaceholder" />
	<msg:message code="Login.passwordPlaceholder" var="passwordPlaceholder" />
	<msg:message code="Login.homeButton" var="home"/>
	


	<div class="container" >
		<form class="form-signin" action="reg" method="post" name="signinForm" data-toggle="validator" role="form">
			<h2 class="featurette-heading">
				${ welcome1 }  <span class="text-muted">${ welcome2 }</span>
			</h2>
			<input type="text" name="username" placeholder="${ usernamePlaceholder }" 
			id="username" class="form-control" onchange="validateUsername();">
			
			<div class="form-group">
				<div class="form-group">
					<input type="password" name="password" placeholder="${ passwordPlaceholder }" data-minlength="6" 
							class="form-control" id="inputPassword" required>
					<span class="help-block">${ minimumChars }</span>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" id="inputPasswordConfirm" data-match="#inputPassword" 
					data-match-error="${ dontMatch }" placeholder="${ confirmPassword }" required>
					<div class="help-block with-errors"></div>
				</div>
			</div>

			<input type="hidden" name="enabled" value="1" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">${ signup }</button>
		</form>
	</div>
	
	
	<div class="container">
		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="welcome">${ home }</a></p>
				<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CREATOR')">
					<p><a href="dashboard"><img src="https://googledrive.com/host/0BweevD4Le1puVXE3cDE2TEZ6ZVk" 
						class="img-responsive"></a></p>
				</security:authorize>
			
			<p>&copy; 2015 Serzh Petukhov</p>
		</footer>
	</div>


	<!-- Placed at the end of the document so the pages load faster -->
	<!-- bootstrap.min.js -->
	<script type='text/javascript'
		src="https://googledrive.com/host/0BweevD4Le1puQU9ZZ0Z1Nm1peFk"></script>
	<!-- validator.min.js -->
	<script type='text/javascript'
		src="https://googledrive.com/host/0BweevD4Le1puWE81X2VOakEwMGM"></script>

</body>
</html>
