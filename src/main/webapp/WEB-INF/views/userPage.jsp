<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg" %>
	

<!DOCTYPE html>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon"
	href="https://vignette2.wikia.nocookie.net/hotline-miami/images/f/f1/Untitled-3.png/revision/latest?cb=20150310222805/">
<title>Files List</title>
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- style.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pubHpOc2tsYV9pZEU" rel="stylesheet">
<!-- signin.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puYzMwQ016VmhHNXc" rel="stylesheet">
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc" rel="stylesheet">

<title>List Of Users Rent</title>
</head>

<body>
	<msg:message code="Main.logoutButton" var="logout"/>
<msg:message code="Main.cartButton" var="cart"/>

	<%@include file="header.jsp"%>
	
	<msg:message code="Main.headerTab" var="headerLine"/>
	<msg:message code="Main.subHeaderTab" var="subHeaderLine"/>
	<msg:message code="Main.addressTab" var="address"/>
	<msg:message code="Main.feeTab" var="fee"/>
	<msg:message code="UserPage.optionTab" var="option"/>
	<msg:message code="Main.backToExplorerLink" var="backToExplorerLink"/>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 main">
				<h1 class="page-header">${ headerLine }</h1>

				<h2 class="sub-header">${ subHeaderLine }</h2>
				<div class="table-responsive">
					<table class="table table-striped" id="display">
						<tr>
        					<th>${ address }</th>
        					<th>${ fee }</th>
        					<th>${ option }</th>
    					</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp">
    	<jsp:param name="linkToReturnTo" value="${ backToExplorerLink }"/>
        <jsp:param name="pageToReturnTo" value="property"/>
    </jsp:include>
	
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- validate.js -->
	<script src="https://googledrive.com/host/0BweevD4Le1puNng4V1Q0a3FOczQ" type='text/javascript'></script>
	<!-- asyncMethods.js -->
	<script src="https://googledrive.com/host/0BweevD4Le1puWnM2YVhZMzNQN0E" type='text/javascript'></script>
	<!-- validator.min.js -->
	<script type='text/javascript' src="https://googledrive.com/host/0BweevD4Le1puWE81X2VOakEwMGM"></script>

</body>
</html>