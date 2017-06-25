<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 9/22/16
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"  type="text/css"/>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
    <script src="/resources/js/jquery.validate.js"></script>
    <script src="/resources/js/login.js"></script>


</head>
<body>
<div class="container" style="width: 40%">
<%--<c:url var="loginUrl" value="/login" />--%>
<form action="${login_url}" method="post" id="login-form">
    <%--${login_url}--%>
    <div class="panel panel-body">
    <c:if test="${param.error != null}">
            <p>Invalid username and password.</p>
    </c:if>
    <c:if test="${param.logout != null}">
            <p>You have been logged out successfully.</p>
    </c:if>
    </div>

    <div class="form-group">
    <h1>LOGIN FORM</h1>
    </div>

    <div class="form-group">
    <label  for="username">Username:</label>
    <input id="username" type="text"  name="username" placeholder="Enter Username" class="form-control" required></div>


    <div class="form-group">
    <label for="exampleInputPassword1">Password:</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Enter Password" required>
    </div>
        <%--<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />--%>

    <button type="submit" class="btn btn-default">login</button>



</form>
    <p style="margin-top: 20px">

        <a href="<c:url value = "/signup"/>">
            <button type="button" class="btn btn-primary">New User</button></a>
    </p>
    <c:if test="${message != null}">
    <div class="alert alert-success" role="alert">
        ${message}
    </div></c:if>
    <c:if test="${failedToAccessTwitter != null}">
        <div class="alert alert-danger" role="alert">
                ${failedToAccessTwitter}
        </div></c:if>
    <c:if test="${twitterAccessTokenFail != null}">
        <div class="alert alert-danger" role="alert">
                ${twitterAccessTokenFail}
        </div></c:if>
    <c:if test="${deniedAuthourization != null}">
        <div class="alert alert-danger" role="alert">
                ${deniedAuthourization}
        </div></c:if>
</div>
</body>
</html>
