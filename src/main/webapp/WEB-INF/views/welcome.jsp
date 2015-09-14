<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://images.akamai.steamusercontent.com/ugc/534009924279689988/BFE1433020371ED995DF224B54F8C13CBF8F3767/">

<title>Welcome to Realty</title>

<!-- Bootstrap core css -->
<!-- bootstrap.min.css -->
<link href="https://googledrive.com/host/0BweevD4Le1puZkNqOFZJNXgyNzA"
	rel="stylesheet" />
<link href="https://googledrive.com/host/0BweevD4Le1puU1JPTkJiVFBaanM/"
	rel="stylesheet">


</head>
<body style="background: url('${ backgroundIMG }') no-repeat scroll 0px 100% / cover transparent;">

	<msg:message code="Welcome.motto" var="motto" />
	<msg:message code="Welcome.homeButton" var="home" />
	<msg:message code="Welcome.contactButton" var="contact" />
	<msg:message code="Welcome.enterButton" var="enter" />

	<!-- languages modal -->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<%@include file="languages.jsp"%>		
			</div>
		</div>
	</div>

	<!-- main -->

	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Realty</h3>
						<nav>
							<ul class="nav masthead-nav">
								<li class="active"><a href="#">${ home }</a></li>
								<li><a href="https://github.com/Demobuster">${ contact }</a></li>
								<li><button type="button" class="btn btn-primary" data-toggle="modal"
											data-target=".bs-example-modal-sm">Language</button></li>
							</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">${ motto }</h1>
					<p class="lead">
						<a href="property" class="btn btn-lg btn-default">${ enter }</a>
					</p>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Founded by <a href="https://github.com/Demobuster">Serzh Petukhov</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- bootstrap.min.js -->
	<script type='text/javascript' src='https://googledrive.com/host/0BweevD4Le1puQU9ZZ0Z1Nm1peFk'></script>
</body>
</html>
