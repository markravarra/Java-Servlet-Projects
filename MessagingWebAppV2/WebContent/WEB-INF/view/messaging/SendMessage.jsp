<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/WEB-INF/view/error/AccessDenied.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Message Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="main.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 850px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 300px;
	background-color: rgb(255, 128, 64, 0.7);
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 18.5px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header icon">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img src="img/konoha2.jpg" width="50" height="50"
					class="d-inline-block align-top mini_logo" alt="">
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/home'/>">Home</a></li>
					<li class="active"><a
						href="<c:url value='/sendmessage'/>">Send
							Message</a></li>
					<li><a
						href="<c:url value='/retrievemessage'/>">Retrieve
							Message</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="navbar-text"><c:out value='${sessionScope.user.userID}' /></li>
					<li class="navbar-header icon1"><img src="img/logo.png"
						width="30" height="30" class="user_logo" alt=""></li>
					<li><a href="#" data-toggle="modal" data-target="#logoutModal"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<div class="quote_container quote_text">
					<blockquote class="blockquote text-center ">
						<p class="mb-1" style="color: white;">"A place where someone
							still thinks about you is a place you can call home."</p>
						<footer class="blockquote-footer blue-grey lighten-5">
							Jiraiya <cite title="Source Title">(Naruto Series)</cite>
						</footer>
					</blockquote>
				</div>
			</div>

			<div class="col-sm-8 form_container mt-5">
				<h1>Send a Message :></h1>
				<c:choose>
					<c:when test="${not empty successMessage}">
						<b><font color="green"><c:out value="${successMessage}" /></font></b>
					</c:when>
					<c:when test="${not empty sendError}">
						<b><font color="red"><c:out value="${sendError}" /></font></b>
					</c:when>
				</c:choose>
				<div class="container-fluid">
					<form action="sendmessage" method="post">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
								<input id="recipient" type="text" class="form-control" name="recipient"
									placeholder="Send to">
						</div>
						<hr>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> 
								<textarea id="messageContent" class="form-control" name="messageContent"
								placeholder="Place your message here"></textarea>
						</div>
						<br>
						<button type="submit" class="btn btn-primary btn-block">Send</button>
					</form>
				</div>
			</div>

			<div class="col-sm-2 sidenav">
				<div>
					<h3><font color="white">Online Users</font></h3>
				</div>
				<div>
					<table class="table table-borderless table-hover">
						<c:forEach var="onlineUser" items="${onlineUsers}">
							<tr>
								<td><b>${onlineUser.userName}</b></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="logoutModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4>
						Log Out <i class="fa fa-lock"></i>
					</h4>
				</div>
				<div class="modal-body">
					<p>
						<i class="fa fa-question-circle"></i> Are you sure you want to logout of the application? <br />
					</p>
					<div class="actionsBtns">
						<form action="logout" method="post">
							<input type="hidden" name="logoutFeedBack" id="logoutFeedBack"
								value="NO" /> <input type="submit"
								class="btn btn-default btn-primary"
								value="Yes" id="logoutFeedBackLink"
								onclick="change()" />
							<button type="submit" class="btn btn-default global-button"
								>No</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<footer class="text-center page-footer font-small special-color-dark">
		<p>@ 2020 Copyright: Dattebayown!!</p>
	</footer>
	
	<script>
		function change() {
			var x = document.getElementById("logoutFeedBack").value = "YES";
		}
	</script>
</body>
</html>