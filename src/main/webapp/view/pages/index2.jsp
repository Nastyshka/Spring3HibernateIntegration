<%--
  Created by IntelliJ IDEA.
  User: AnastasiyaR
  Date: 6/14/13
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Timetable</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        <%@ include file="/view/css/tableStyle.css"%>
    </style>

</head>

<body>
<form:form action="home2.do" method="get" commandName="hp" name="hpForm" id="hpForm">
<div id="header">
    <hr>
    <h1><a href="/timetable/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg" height="57" width="57"/></a>Інститут післядипломної освіти НТУУ КПІ</h1>
    <hr>
</div>

<div id="content">

    <span class="scroll"></span>



    <c:if test="${empty hp.teacher}">
        <h1>Розклад викладачів </h1>
    </c:if>

    <c:if test="${not empty hp.teacher}">
        <h1>Розклад викладача ${hp.teacher.nameUser}</h1>
    </c:if>

    <c:url value="/home.do" var="profileUrl">
        <%--<c:param name="idTeacher" value="${teacher.idTeacher}"/>--%>
    </c:url>
    <a name="tt" href="${profileUrl}"/><c:out value="Розклад груп студентів"/></a> </br>


    <c:if test="${not empty hp.teachers}">
        <form:label path="teacher">Викладачі</form:label>
        <form:select path="teacher" type="text" items="${hp.teachers}" itemLabel="nameUser" itemValue="idTeacher" multiple="false" title=""/>
    </c:if>

    <input type="submit" value="Знайти">
    <table class="table1">
        <thead>
        <tr>
            <th></th>
            <th scope="col" abbr="monday">Понеділок</th>
            <th scope="col" abbr="tuesday">Вівторок</th>
            <th scope="col" abbr="wednesday">Середа</th>
            <th scope="col" abbr="saturday">Четвер</th>
            <th scope="col" abbr="friday">П'ятниця</th>
        </tr>

        </thead>

        <tr>
            <th scope="row">1</th>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
        <tbody>
        <tr>
            <th scope="row">2</th>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
        <tr>
            <th scope="row">5</th>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
        <tr>
            <th scope="row">6</th>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
        </tbody>
    </table>
    </form:form>
</div>

</body>
</html>