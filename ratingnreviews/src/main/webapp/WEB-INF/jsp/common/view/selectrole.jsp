<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<style>
.underline-on-hover:hover {
	text-decoration: underline;
	cursor: pointer;
	cursor: hand;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Select Role</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/login/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300'
	rel='stylesheet' type='text/css'>
<link
	href="${pageContext.request.contextPath}/login/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/login/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/login/css/style-responsive.css"
	rel="stylesheet">
</head>
<body>
	<div class="login-container">

		<div class="middle-login">
			<a href="${pageContext.request.contextPath}">
				<div class="login-logo">
					<img src="images/login-page-logo.gif" alt="logo" />
				</div>
			</a>
			<div class="block-web">
				<div class="head">
					<h3>Please Select a Role</h3>
				</div>
				<div style="background: #fff;">
					<div class="content">
						<form name='form' action="selectRole"
							id="selectroleform" method='POST'
							style="min-height:40px; margin-bottom: 10px !important;">

							<div class="form-group" >
								<c:forEach items="${userRoleDos }" var="userRoleDo">
									<label class="col-sm-${12/fn:length(userRoleDos) } radio-inline"><input name="userrole" type="radio" name="optradio" value="${userRoleDo.role }" onclick="$('#selectroleform').submit();"><c:out value="${userRoleDo.role }"></c:out> </label>
								</c:forEach>
							</div>
						</form>
					</div>



				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="login/js/jquery-2.0.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="login/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>

</body>
</html>
