<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: AnastasiyaR
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style>
    </style>
    <title>Profile</title>
</head>
<body>

<div id="header">
    <hr>
    <h1><a href="/timetable/home.do" title="Start page"><img src="view/img/Logo.jpg" width="77" height="67"/></a>${person.name}</h1>
    <hr>
</div>

<form:form action="/foundTeachers.do" method="post">
</form:form>
</body>
</html>