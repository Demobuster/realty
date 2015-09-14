<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://images.akamai.steamusercontent.com/ugc/534009924279689988/BFE1433020371ED995DF224B54F8C13CBF8F3767/">
<title>Add Property</title>

<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- style.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pubHpOc2tsYV9pZEU" rel="stylesheet">
<!-- validate.js -->
<script type="text/javascript" src="https://googledrive.com/host/0BweevD4Le1puNng4V1Q0a3FOczQ"></script>
	

</head>
<body>	
	<%@include file="header.jsp"%>

	<msg:message code="Admin.addProperty" var="addProperty"/>
	<msg:message code="Admin.address" var="address"/>
	<msg:message code="Admin.fee" var="fee"/>
	<msg:message code="Admin.description" var="description"/>
	<msg:message code="Search.add" var="add"/>
	<msg:message code="Search.reset" var="reset"/>
	<msg:message code="Dashboard.backToDashboard" var="backToDashboard"/>
	
    <h1>${ addProperty }</h1>
    <form:form action="addPropertyToDB" method="post">
      ${ address }: <form:input path="propAddress" id="propAddress" onchange="validateAddress();"/><br/>
      ${ fee }: <form:input path="propFee" id="propFee" onkeyup="validateFee();" /><br/>
      ${ description }:<br/> <form:textarea path="propDescription" rows="20" id="propDescription"
      										onchange="validateDescription();"	/> <br/>
      <input type="reset" value="${ reset }"/>
      <input type="submit" value="${ add }"/>
    </form:form>
    
    <jsp:include page="footer.jsp">
    	<jsp:param name="linkToReturnTo" value="${ backToDashboard }"/>
        <jsp:param name="pageToReturnTo" value="dashboard"/>
    </jsp:include>
    
</body>
</html>