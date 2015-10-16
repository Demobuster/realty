<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg" %>

<!DOCTYPE html>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="https://vignette2.wikia.nocookie.net/hotline-miami/images/f/f1/Untitled-3.png/revision/latest?cb=20150310222805/">

<title>Found Property</title>

<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- style.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pubHpOc2tsYV9pZEU" rel="stylesheet">
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc" rel="stylesheet">

<body>
	<%@include file="header.jsp"%>
	
	<msg:message code="Main.headerTab" var="headerLine"/>
	<msg:message code="Main.subHeaderTab" var="subHeaderLine"/>
	<msg:message code="Main.addressTab" var="address"/>
	<msg:message code="Main.descriptionTab" var="description"/>
	<msg:message code="Main.feeTab" var="fee"/>
	<msg:message code="Main.optionTab" var="option"/>
	<msg:message code="Main.hireButton" var="hire"/>
	<msg:message code="Main.backToExplorerLink" var="backToExplorerLink"/>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 main">
				<h1 class="page-header">${ headerLine }</h1>

				<h2 class="sub-header">${ subHeaderLine }</h2>
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
						<c:if test="${!empty foundProp}">
							<c:forEach var="p" items="${foundProp}">
								<tr>
									<td>${p.propAddress}</td>
									<td>${p.propDescription}</td>
									<td>${p.propFee}</td>
									<td><a href="hire/${p.id}">Hire</a></td>
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