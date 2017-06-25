<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgfu
  Date: 10/2/16
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>searchResult</title>
</head>
<body>
<a href="/logout">logout</a><br>
<a href="/homePage">homepage</a><br>
<c:forEach items="${statuses}" var="status">
    <p><c:out value="${status.getUser().getName()}"/><br>
    <c:out value="${status.getText()}"/></p>
</c:forEach>
</body>
</html>
