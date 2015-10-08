<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="msg"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="http://images.akamai.steamusercontent.com/ugc/534009924279689988/BFE1433020371ED995DF224B54F8C13CBF8F3767/">

<title>Dashboard Page</title>
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- dashboard.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pueTFOMU4zLXV5Znc"	rel="stylesheet">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc" rel="stylesheet">

</head>

<body>

	<msg:message code="Dashboard.headerLine" var="headerLine" />
	<msg:message code="Dashboard.descriptionUsers" var="descriptionUsers" />
	<msg:message code="Dashboard.labelProp" var="labelProp" />
	<msg:message code="Dashboard.descriptionProp" var="descriptionProp" />
	<msg:message code="Dashboard.labelUsers" var="labelUsers" />
	<msg:message code="Dashboard.mainTab" var="mainTab" />
	<msg:message code="Dashboard.labelPropManagement" var="labelPropManagement" />
	<msg:message code="Dashboard.descriptionPropManagement" var="descriptionPropManagement" />
	<msg:message code="Main.backToExplorerLink" var="backToExplorerLink" />


	<%@include file="header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="dashboard">${ mainTab } ${ sessionScope.role }<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">${ headerLine }</h1>

				<div class="row placeholders">
					
					<security:authorize access="hasRole('ROLE_ADMIN')">					
						<div class="col-xs-6 col-sm-3 placeholder">
							<a href="usersManagement"><img
								src="https://googledrive.com/host/0BweevD4Le1puck9STzVHWjI2b0U"
								class="img-responsive"></a>
							<h4>${ labelUsers }</h4>
							<span class="text-muted">${ descriptionUsers }</span>
						</div>
					</security:authorize>

					<security:authorize access="hasRole('ROLE_CREATOR')">	
						<div class="col-xs-6 col-sm-3 placeholder">
							<a href="addProperty"><img
								src="https://googledrive.com/host/0BweevD4Le1puNkRCWnhobGV0bEk"
								class="img-responsive"></a>
							<h4>${ labelProp }</h4>
							<span class="text-muted">${ descriptionProp }</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder">
							<a href="propManagement"><img
								src="https://googledrive.com/host/0BweevD4Le1pubTJqb0tubGFQNkU"
								class="img-responsive"></a>
							<h4>${ labelPropManagement }</h4>
							<span class="text-muted">${ descriptionPropManagement }</span>
						</div>
					</security:authorize>
					
				</div>
				<jsp:include page="footer.jsp">
					<jsp:param name="linkToReturnTo" value="${ backToExplorerLink }" />
					<jsp:param name="pageToReturnTo" value="property" />
				</jsp:include>
			</div>

		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- bootstrap.min.js -->
	<script type='text/javascript'
		src='https://googledrive.com/host/0BweevD4Le1puQU9ZZ0Z1Nm1peFk'></script>
</body>
</html>
