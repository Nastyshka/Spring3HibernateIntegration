<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Timetable</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="Pimp your tables with CSS3"/>
    <meta name="keywords" content="table, css3, style, beautiful, fancy, css"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen"/>
    <style>
        <%@ include file="/view/css/tableStyle.css"%>
    </style>
</head>
<style>

</style>
<body>
<div id="header">
    <hr>
    <h1><a href="/timetable/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg"
                                                             height="57" width="57"/></a>КПИяшка</h1>
    <hr>
</div>
<div id="content">
    <a class="back" href=""></a>
    <span class="scroll"></span>

</div>
<form:form method="post" action="/timetable/addTimeslot.do" commandName="timeslot">
    <form:hidden path="idTimeSlot"/>
    <table>
        <tr>
            <td><form:label path="lessonNumber">Номер пари</form:label></td>
            <td><form:input path="lessonNumber" name="command.lessonNumber" type="text" value="${command.lessonNumber}"/></td>
        </tr>

        <tr>
            <td><form:label path="dayOfWeek">День тижня</form:label></td>
            <td><form:select path="dayOfWeek" type="text" items="${daysOfWeek}" multiple="false"/></td>
        </tr>

        <tr>
            <td><form:label path="startTime">Початок пари</form:label></td>
            <td><form:input path="startTime" name="command.startTime" type="text" value="${command.startTime}"/></td>
        </tr>

        <tr>
            <td><form:label path="endTime">Початок пари</form:label></td>
            <td><form:input path="endTime" name="command.endTime" type="text" value="${command.endTime}"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Зберегти"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

