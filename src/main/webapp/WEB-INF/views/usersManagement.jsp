<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="msg" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="https://vignette2.wikia.nocookie.net/hotline-miami/images/f/f1/Untitled-3.png/revision/latest?cb=20150310222805/">

<title>Users Management Page</title>

<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- dashboard.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pueTFOMU4zLXV5Znc" rel="stylesheet">
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc" rel="stylesheet">

</head>

<body>
	<%@include file="header.jsp"%>
	
	<msg:message code="Login.usernamePlaceholder" var="usernamePlaceholder"/>
	<msg:message code="Login.passwordPlaceholder" var="passwordPlaceholder"/>
	<msg:message code="UserPage.optionTab" var="option"/>
	<msg:message code="Dashboard.backToDashboard" var="backToDashboard"/>
	<msg:message code="Dashboard.labelUsers" var="labelUsers"/>
	<msg:message code="Dashboard.headerUsersList" var="headerUsersList"/>
	

	<div class="container-fluid">
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">${ labelUsers }</h1>

				<h2 class="sub-header">${ headerUsersList }</h2>
				<div class="table-responsive">
					<table class="table table-striped" id="displayUsers">
						<tr>
        					<th>${ usernamePlaceholder }</th>
        					<th>${ passwordPlaceholder }</th>
        					<th>${ option }</th>
    					</tr>
					</table>
				</div>
			</div>
			
			<jsp:include page="footer.jsp">
    			<jsp:param name="linkToReturnTo" value="${ backToDashboard }"/>
        		<jsp:param name="pageToReturnTo" value="dashboard"/>
    		</jsp:include>
	</div>
	
	<!-- bootstrap.min.js -->
	<script type='text/javascript' src='https://googledrive.com/host/0BweevD4Le1puQU9ZZ0Z1Nm1peFk'></script>
	<!-- JSONMethods.js -->
	<script src="https://googledrive.com/host/0BweevD4Le1puWnM2YVhZMzNQN0E" type='text/javascript'></script>
</body>
</html>
