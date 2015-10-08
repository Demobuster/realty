<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>	

	<div class="container">
		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="${ param.pageToReturnTo }">${ param.linkToReturnTo }</a></p>
				<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CREATOR')">
					<p><a href="dashboard"><img src="https://googledrive.com/host/0BweevD4Le1puVXE3cDE2TEZ6ZVk" 
						class="img-responsive"></a></p>
				</security:authorize>
			
			<p>&copy; 2015 Serzh Petukhov</p>
		</footer>
	</div>

	<!-- jquery.min.js -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- bootstrap.min.js -->
	<script type='text/javascript' src='https://googledrive.com/host/0BweevD4Le1puQU9ZZ0Z1Nm1peFk'></script>