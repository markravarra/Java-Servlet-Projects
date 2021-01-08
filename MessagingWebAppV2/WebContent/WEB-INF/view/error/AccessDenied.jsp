<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAGE ACCESS DENIED!</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
body {
	background-image: url("img/error.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}

div {
	width: 100px;
	height: 100px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
}

.error_card {
	padding: 70px 0;
	border: 3px solid green;
	text-align: center;
	vertical-align: middle;
	position: absolute;
	background: rgb(0, 0, 0, 0.85);
}
</style>
</head>
<body>
	<div class="container-fluid h-100 pt-3 error_card">
		<div class="text-center"
			style="width: 100%; color: red; font-size: 1em;">
			<h1>ERROR: PAGE ACCESS DENIED!!</h1>
			<!-- ${pageContext.exception} -->
			<hr>
			<ul>
				<li>Unauthenticated access: You were trying to access an
					unauthorized page!</li>
			</ul>
			<p class="text-center" style="width: 100%; font-size: 1em;">
				Try again by <a href="${pageContext.request.contextPath}">re-login</a>
			</p>
		</div>
	</div>
</body>
</html>