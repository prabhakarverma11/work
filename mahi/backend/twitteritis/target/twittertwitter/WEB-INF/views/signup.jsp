<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 9/23/16
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>signup</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"  type="text/css"/>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
    <script src="/resources/js/jquery.validate.js"></script>
    <script src="/resources/js/signup.js"></script>

</head>
<body>
<div class="container" style= "width:40%">
<div class="form-group">
    <h1>SIGNUP FORM</h1></div>

<spring:url var="loginVar" value="/signup"/>
<form action="${loginVar}" method="post" id="signup-form">

    <div class="form-group">
    <label for="username">Enter new Username:</label>
    <input name="username" type="text" class="form-control" id="username" placeholder="John Doe" required/>
    </div>

    <div class="form-group"><label for="password">
        Enter New Password:</label>
    <input name="password" placeholder="password" id="password" type="password" class="form-control"  required/></div>

    <div class="form-group">
        <label for="repassword">
            Reenter Password
        </label>
        <input class="form-control" placeholder="password" id="repassword" type="password" name="repassword" required/>
    </div>

    <button type="submit" class="btn btn-primary btn-large">Submit</button>
</form>
    <c:if test="${sameUsermsg != null}">
        <div class="alert alert-danger" role="alert">
                ${sameUsermsg}
        </div></c:if>
</div>
</body>
</html>
