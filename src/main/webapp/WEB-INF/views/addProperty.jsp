<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg"%>

<!DOCTYPE html>
<html lang="ru">
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
<!-- jquery.min.js -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

</head>
<body>
	<msg:message code="Admin.addProperty" var="addProperty"/>
	<msg:message code="Admin.address" var="address"/>
	<msg:message code="Admin.fee" var="fee"/>
	<msg:message code="Admin.description" var="description"/>
	<msg:message code="Search.add" var="add"/>
	<msg:message code="Search.reset" var="reset"/>
	
    <h1>${ addProperty }</h1>
    <form:form action="addPropertyToDB" method="post">
      ${ address }: <form:input path="propAddress"/><br/>
      ${ fee }: <form:input path="propFee" /><br/>
      ${ description }:<br/> <form:textarea path="propDescription" rows="20"/><br/>
      <input type="reset" value="${ reset }"/>
      <input type="submit" value="${ add }"/>
    </form:form>
    
    <%@include file="footer.jsp"%>
    
    
</body>
</html>