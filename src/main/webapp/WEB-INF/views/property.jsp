<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="msg" %>

<!DOCTYPE html>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="http://images.akamai.steamusercontent.com/ugc/534009924279689988/BFE1433020371ED995DF224B54F8C13CBF8F3767/">
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- style.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pubHpOc2tsYV9pZEU" rel="stylesheet">
<!-- signin.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puYzMwQ016VmhHNXc" rel="stylesheet">
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc" rel="stylesheet">
<!-- jquery.min.js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<!-- validate.js -->
<script src="https://googledrive.com/host/0BweevD4Le1puNng4V1Q0a3FOczQ" type='text/javascript'></script>
<!-- asyncMethods.js -->
<script src="https://googledrive.com/host/0BweevD4Le1puWnM2YVhZMzNQN0E" type='text/javascript'></script>


<title>List Of Avaliable Properties</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<msg:message code="Main.headerTab" var="headerTab"/>
	<msg:message code="Main.subHeaderTab" var="subHeaderTab"/>
	<msg:message code="Main.addressTab" var="address"/>
	<msg:message code="Main.descriptionTab" var="description"/>
	<msg:message code="Main.feeTab" var="fee"/>
	<msg:message code="Main.optionTab" var="option"/>
	<msg:message code="Main.hireButton" var="hire"/>
	<msg:message code="Main.hireButton" var="hire"/>
	<msg:message code="Search.search" var="search"/>
	<msg:message code="Search.reset" var="reset"/>
	<msg:message code="Search.searchHelp" var="searchHelp"/>
	<msg:message code="Main.backToExplorerLink" var="backToExplorerLink"/>
	

	<div class="container">
		<form action="doSearch" method="post" class="form-signin">
			<input type="text" name="searchText" placeholder="${ searchHelp }" />	<br/> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<input type="reset"	value="${ reset }" />
			<input type="submit" value="${ search }" />
		</form>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 main">
				<h1 class="page-header">${ headerTab }</h1>

				<h2 class="sub-header">${ subHeaderTab }</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>${ address }</th>
								<th>${ description }</th>
								<th>${ fee }</th>
								<th>${ option }</th>
							</tr>
						</thead>
						<c:if test="${!empty property}">
							<c:forEach items="${propertyList}" var="property">
								<tr>
									<td>${property.address}</td>
									<td>${property.description}</td>
									<td>${property.fee}</td>
									<td><a href="javascript:void(0);" id="hireLink" 
												onclick="executeStateProperty('hire/${property.id}');">Hire</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp">
    	<jsp:param name="linkToReturnTo" value="${ backToExplorerLink }"/>
        <jsp:param name="pageToReturnTo" value="property"/>
    </jsp:include>

</body>
</html>