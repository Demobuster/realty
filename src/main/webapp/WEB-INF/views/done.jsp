<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="https://vignette2.wikia.nocookie.net/hotline-miami/images/f/f1/Untitled-3.png/revision/latest?cb=20150310222805/">
<title>Done</title>
  
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA" rel="stylesheet" />
<!-- style.css -->
<link href="https://googledrive.com/host/0BweevD4Le1pubHpOc2tsYV9pZEU" rel="stylesheet">
<!-- mystyle.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puWEIzMmUwemZNdnc" rel="stylesheet">

</head>
<body>
	<msg:message code="Main.addressTab" var="addressTab" />
	<msg:message code="Main.descriptionTab" var="descriptionTab" />
	<msg:message code="Main.feeTab" var="feeTab"/>
	<msg:message code="Admin.successfully" var="successfully"/>
	<msg:message code="Dashboard.backToDashboard" var="backToDashboard"/>
	
    <h1>${ successfully }:</h1>
    ${ addressTab }: 	 <p>${ address }</p> 
    ${ descriptionTab }: <p>${ description }</p>
   	${ feeTab }: 		 <p>${ fee }</p>  
    
    <jsp:include page="footer.jsp">
    	<jsp:param name="linkToReturnTo" value="${ backToDashboard }"/>
       	<jsp:param name="pageToReturnTo" value="dashboard"/>
    </jsp:include>
    
</body>
</html>