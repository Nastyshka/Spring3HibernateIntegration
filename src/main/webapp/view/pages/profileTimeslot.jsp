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
    <style>
        <%@ include file="/view/css/tableStyle.css"%>
        <%@include file="/view/css/index.css" %>
    </style>
</head>

<body style="background-image: url(${pageContext.request.contextPath}/view/img/back1.jpg);
        background-attachment: scroll;
        background-position: center;">
<div class="wrapper">
    <div class="header">
        <a class="header_link" href="/home.do">
            <img src="${pageContext.request.contextPath}/view/img/logo.png" class="header_logo" hight="57" width="48">
            <span class="header_title">Інститут післядипломної освіти НТУУ КПІ</span>
        </a>
    </div>
    <div id="content">
        <a class="back" href=""></a>
        <span class="scroll"></span>

    </div>
    <form:form method="post" action="/timetable/addTimeslot.do" commandName="timeslot">
    <form:hidden path="idTimeSlot"/>

    <div class="main_title">Розклад заняття</div>
    <table>
        <tr>
            <td><form:label path="lessonNumber">Номер пари</form:label></td>
            <td><form:input path="lessonNumber" name="command.lessonNumber" type="text"
                            value="${command.lessonNumber}"/></td>
        </tr>

        <tr>
            <td><form:label path="dayOfWeek">День тижня</form:label></td>
            <td><form:select path="dayOfWeek" type="text" items="${daysOfWeek}" multiple="false" cssClass="form_select"/></td>
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
                <input type="submit" value="Зберегти" class="form_button"/>
            </td>
        </tr>
    </table>
</div>

</form:form>
</body>
</html>

