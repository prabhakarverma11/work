<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 9/28/16
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>post page</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"  type="text/css"/>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
    <script src="/resources/js/jquery.validate.js"></script>
    <script src="/resources/js/post.js"></script>
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
                <li class="active"><a href="/post">Post</a></li>
                <li><a href="/search">Search</a> </li>
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
                <li><a href="/message">Message</a> </li>
                <%--<li><a href="/logout">Logout</a> </li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Logout</a></li></ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container" style="width:40%;margin-top: 60px" >
<h1>TWEET</h1>
<form action="/post" method="post" id="post-form" style="margin-top: 40px">
    <div class="form-group" >
    <label for="post-tweet">Enter your tweet:</label>
    <%--<input  type="" id="post-tweet" name="string" size="40"/>--%>
    <textarea name="string" class="form-control" id="post-tweet" placeholder="Tweet" cols="6" rows="10" ></textarea>
    </div>

    <button type="submit" class="btn btn-primary btn-lg btn-block">POST</button>
    <%--<input type="submit" value="tweet"/>--%>
</form>
    <c:if test="${failtweetmsg != null}">
    <div class="alert alert-danger">
        ${failtweetmsg}
        </div></c:if>
    </div>
</body>
</html>
