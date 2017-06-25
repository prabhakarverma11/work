<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 10/2/16
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>profile</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css" type="text/css"/>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
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
                <li class="active"><a href="/profile">Profile</a></li>
                <li><a href="/latest_tweets">Latest</a></li>
                <li><a href="/post">Post</a></li>
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
<div class="container" style="width:80%;margin-top: 60px" >
<h1>Your Profile</h1>
<img src="${user.getProfileImageUrl()}" class="img-responsive" align="center" />
<table class="table table-striped table-hover" style="margin-top: 20px">
    <tr class="info"><td>Twitter Id:</td><td>${user.getTwitterId()}</td></tr>
    <tr class="info"><td>Name:</td><td>${user.getName()}</td></tr>
    <tr class="info"><td>Email:</td><td>${user.getEmail()}</td></tr>
    <tr class="info"><td>ScreenName:</td><td>${user.getScreenName()}</td></tr>
    <tr class="info"><td>Location:</td><td>${user.getLocation()}</td></tr>
    <tr class="info"><td>  Description:</td><td>${user.getDescription()}</td></tr>
    <tr class="info"><td>Followers Count:</td><td>${user.getFollowersCount()}</td></tr>
    <tr class="info"><td> Friends Count:</td><td>${user.getGetFriendsCount()}</td></tr>
    <tr class="info"><td>Favourites Count:</td><td>${user.getGetFavouritesCount()}</td></tr>
    <tr class="info"><td>Created AT:</td><td>${user.getGetCreatedAt()}</td></tr>

</table>
</div>
</body>
</html>
