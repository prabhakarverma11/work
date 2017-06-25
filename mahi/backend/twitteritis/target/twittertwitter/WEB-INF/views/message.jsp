<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 10/3/16
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>message page</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"  type="text/css"/>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
    <script src="/resources/js/jquery.validate.js"></script>
    <script src="/resources/js/message.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Twitter</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/profile">Profile</a></li>
                <li><a href="/latest_tweets">Latest</a></li>
                <li><a href="/post">Post</a></li>
                <li ><a href="/search">Search</a> </li>
                <li class="dropdown">
                    <a href="/analytics" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Analytics <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/analytics">Analytics</a> </li>
                        <li role="separator" class="divider"></li>
                        <li><a href="/appMessages">Messages Sent</a></li>
                        <li><a href="/appSearches">Searches Done</a></li>
                        <li><a href="/appTweets">Tweets Posted</a></li>
                    </ul>
                </li>
                <li  class="active"><a href="/message">Message</a> </li>
                <%--<li><a href="/logout">Logout</a> </li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout</a></li></ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container" style="width:40%;margin-top: 60px" >
<h1>Send Message</h1>
<form action="/message" method="post" id="message-form">
    <div class="form-group">
        <label for="message-handle">Enter User Handle:</label>
    <input  type="text" name="handle" size="40" id="message-handle" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="message-msg">Enter the message:</label>
    <%--<input type="text" name="mesg" size="40" id="message-msg" class="form-control"/>--%>
        <textarea class="form-control" name="mesg" id="message-msg" rows="10"></textarea>
    </div>
    <%--<input type="submit" value="send"/>--%>
    <button type="submit" class="btn btn-primary btn-lg btn-block">SEND MESSAGE</button>
</form>
<c:if test="${failedMessage !=null}">
    <div class="alert alert-danger">
    ${failedMessage}</div>
</c:if> </div>
</body>
</html>
