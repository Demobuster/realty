<msg:message code="Main.logoutButton" var="logout"/>
<msg:message code="Main.cartButton" var="cart"/>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="welcome">Realty</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse"
				aria-expanded="false" style="height: 0.800000011920929px;">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="userPage">${ cart }</a></li>
					<li><a href="javascript:formSubmit()">${ logout }</a></li>
				</ul>
			</div>
		</div>
	</nav>