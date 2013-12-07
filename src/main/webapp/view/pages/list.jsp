<%--<%@ page import="app.model.Dao" %>--%>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: AnastasiyaR
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
    </style>
    <title>Found persons</title>
</head>

<body>

<div id="header">
    <hr>
    <h1><a href="/mvc/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg" width="77" height="67" alt="Genea"/></a>КПИяшка</h1>
    <hr>
</div>

<form:form action="/profile" method="post">
    <c:if test="${not empty foundTeachers}">
        <h2>Список вчителів</h2>
        <form>
            <c:forEach items="${foundTeachers}" var="person">
                <c:url value="/profileTeacher.do" var="profileUrl">
                    <c:param name="selectedPerson" value="${person.idperson}"/>
                </c:url>
                <a name="selected" href="${profileUrl}"/><c:out value="${person.name}"/></a> </br>
            </c:forEach>
        </form>
    </c:if>

    <c:if test="${empty foundTeachers}" >
        <c:out value="Вказаних людей не знайдено"/>
    </c:if>
</form:form>
</body>
</html>