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
    <title>All info</title>
</head>

<body>

<div id="header">
    <hr>
    <h1><a href="/timetable/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg" height="57" width="57"/></a>Інститут післядипломної освіти КПІ</h1>
    <hr>
</div>


<%--Subject--%>
<c:if test="${not empty foundData.subjects}">
    <h2>Список предметів</h2>
    <form>
        <c:forEach items="${foundData.subjects}" var="subject">
            <c:url value="/profileSubject.do" var="profileUrl">
                <c:param name="selectedSubject" value="${subject.idSubject}"/>
            </c:url>
            <a name="selected" href="${profileUrl}"/><c:out value="${subject.nameSubject}"/></a> </br>
        </c:forEach>
    </form>
</c:if>

<c:if test="${empty foundData.subjects}" >
    <c:out value="Немає даних про предмети"/>
</c:if>

<form action="/timetable/profileSubject.do" method="get">
    <input type="submit" value="Додати"/>
</form>

<%--Group--%>
<c:if test="${not empty foundData.groups}">
    <h2>Список груп</h2>
    <form>
        <c:forEach items="${foundData.groups}" var="group">
            <c:url value="/profileGroup.do" var="profileUrl">
                <c:param name="selectedGroup" value="${group.idStudentGroup}"/>
            </c:url>
            <a name="selected" href="${profileUrl}"/><c:out value="${group.nameGroup}"/></a> </br>
        </c:forEach>
    </form>
</c:if>

<c:if test="${empty foundData.groups}" >
    <c:out value="Немає даних про групи"/>
</c:if>

<form:form action="/timetable/profileGroup.do" method="get">
    <input type="submit" value="Додати"/>
</form:form>

<%--Classroom--%>
<c:if test="${not empty foundData.classrooms}">
    <h2>Список аудиторій</h2>
    <form>
        <c:forEach items="${foundData.classrooms}" var="classroom">
            <c:url value="/profileClassroom.do" var="profileUrl">
                <c:param name="selectedClassroom" value="${classroom.idClassroom}"/>
            </c:url>
            <a name="selected" href="${profileUrl}"/><c:out value="${classroom.number}"/></a> </br>
        </c:forEach>
    </form>
</c:if>

<c:if test="${empty foundData.classrooms}" >
    <c:out value="Немає даних про аудиторії"/>
</c:if>

<form:form action="/timetable/profileClassroom.do" method="GET">
    <input type="submit" value="Додати"/>
</form:form>

<%--Teacher--%>
<c:if test="${not empty foundData.teachers}">
    <h2>Список вчителів</h2>
    <form>
        <c:forEach items="${foundData.teachers}" var="teacher">
            <c:url value="/profileTeacher.do" var="profileUrl">
                <c:param name="selectedPerson" value="${teacher.idTeacher}"/>
            </c:url>
            <a name="selected" href="${profileUrl}"/><c:out value="${teacher.nameUser}"/></a> </br>
        </c:forEach>
    </form>
</c:if>

<c:if test="${empty foundData.teachers}" >
    <c:out value="Немає даних про викладачів"/>
</c:if>
<form:form action="/timetable/profileTeacher.do" method="get">
    <input type="submit" value="Додати"/>
</form:form>

<%--Timeslot--%>
<c:if test="${not empty foundData.timeSlots}">
    <h2>Розклад</h2>
    <form>
        <c:forEach items="${foundData.timeSlots}" var="timeslot">
            <c:url value="/profileTimeslot.do" var="profileUrl">
                <c:param name="selectedTimeslot" value="${timeslot.idTimeSlot}"/>
            </c:url>
            <a name="selected" href="${profileUrl}"/>${timeslot.dayOfWeek}-${timeslot.lessonNumber}</a> </br>
        </c:forEach>
    </form>
</c:if>

<c:if test="${empty foundData.timeSlots}" >
    <c:out value="Немає даних про розклад"/>
</c:if>
<form:form action="/timetable/profileTimeslot.do" method="get">
    <input type="submit" value="Додати"/>
</form:form>
</body>
</html>