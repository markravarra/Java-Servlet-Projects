<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
</head>
<meta charset="ISO-8859-1">
<body>
	<div class="container-fluid h-100 pt-3">
		<div class="d-flex justify-content-start h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="img/nerto.png" class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-inline justify-content-center form_container mt-5">
					<form action="login" method="post">
						<div class="input-group mb-3 input-group-lg">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="userID" class="form-control input_user"
								value="${userID}" placeholder="User ID" maxlength="20">
						</div>

						<div class="input-group mb-2 input-group-lg">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="password"
								class="form-control input_pass" value="" placeholder="Password"
								maxlength="20">
						</div>
						<div class="d-flex justify-content-center text-center error">
							<c:if test="${not empty errorMessage}">
								<c:out value="${errorMessage}" />
							</c:if>
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
							<button type="submit" name="button" class="btn login_btn">Login</button>
						</div>
					</form>
				</div>

				<div
					class="d-flex align-content-lg-end justify-content-center flex-wrap">
					<div class="quote_container quote_text">
						<blockquote class="blockquote text-center ">
							<p class="mb-1" style="color: white;">Hard work is worthless
								for those that don't believe in themselves!</p>
							<footer class="blockquote-footer">
								Naruto Uzumaki <cite title="Source Title">(Naruto Series)</cite>
							</footer>
						</blockquote>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
	<script
		src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script>
		$(document).ready(function() {
			swal('Oops', 'User does not Exist!', 'error');
		});
	</script>
</body>
</html>