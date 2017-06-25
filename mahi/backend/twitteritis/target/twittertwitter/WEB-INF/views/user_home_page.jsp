<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 9/27/16
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>user_home_page</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css" type="text/css"/>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
</head>
<body>
<div class="jumbotron" align="center">
    <div class="container">
        <h1>Twitter App</h1>
        <p>This is a demo twitter app which uses twitter4j to use the twitter REST api.</p>
    </div>
</div>
<div class="container" align="center">
    <ul class="list-group">
        <li class="list-group-item"><a href="/post">POST A TWEET</a></li>
        <li class="list-group-item"><a href="/latest_tweets">Get Latest Tweets</a></li>
        <li class="list-group-item"><a href="/message">Send Messages</a></li>
        <li class="list-group-item"><a href="/search">Search Timeline</a></li>
        <li class="list-group-item"><a href="/analytics">Analytics for Your Profile</a></li>
        <li class="list-group-item"><a href="/profile">Your Profile</a></li>
        <li class="list-group-item"><a href="/friend_timeline">Timeline(pagination)</a></li>
        <li class="list-group-item"><a href="/logout">Logout</a></li>
    </ul>
    <p>${message1}</p>
    <c:if test="${posttweetmsg != null}">
        <div class="alert alert-success" role="alert">
                ${posttweetmsg}
        </div></c:if>
    <c:if test="${messageSent!= null}">
        <div class="alert alert-success" role="alert">
                ${messageSent}
        </div></c:if>
    <c:if test="${failLatestTweet != null}">
        <div class="alert alert-danger" role="alert">
                ${failLatestTweet}
        </div></c:if>
</div>
</body>
</html>
