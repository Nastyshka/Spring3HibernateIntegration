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
    <title>All info</title>
</head>

<body>

<div id="header">
    <hr>
    <h1><a href="/timetable/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg" height="57" width="57"/></a>КПИяшка</h1>
    <hr>
</div>

<form:form action="/timetable/profileSubject.do" method="post">
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

    <%--<a name="createSubject" href="/profileSubject.do"/><c:out value="Додати предмет"/></a> </br>--%>
    <input type="submit" value="Додати предмет"/>
</form:form>

<%--Group--%>
<form:form action="/timetable/profileGroup.do" method="post">
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

    <%--<a name="createTeacher" href="/timetable/profileGroup.do"/><c:out value="Додати групу"/></a> </br>--%>
    <input type="submit" value="Додати групу"/>
</form:form>
<%--Classroom--%>
<form:form action="/timetable/profileClassroom.do" method="post">
    <c:if test="${not empty foundData.classrooms}">
        <h2>Список аудиторій</h2>
        <form>
            <c:forEach items="${foundData.classrooms}" var="classroom">
                <c:url value="/profileTeacher.do" var="profileUrl">
                    <c:param name="selectedClassroom" value="${classroom.idClassroom}"/>
                </c:url>
                <a name="selected" href="${profileUrl}"/><c:out value="${classroom.number}"/></a> </br>
            </c:forEach>
        </form>
    </c:if>

    <c:if test="${empty foundData.classrooms}" >
        <c:out value="Немає даних про аудиторії"/>
    </c:if>

    <input type="submit" value="Додати аудитоію"/>
    <%--<a name="createClassroom" href="/profileClassroom.do"/><c:out value="Додати аудиторію"/></a> </br>--%>
</form:form>
<%--Teacher--%>
<form:form action="/timetable/profileTeacher.do" method="post">
    <c:if test="${not empty foundData.teachers}">
        <h2>Список вчителів</h2>
        <form>
            <c:forEach items="${foundData.teachers}" var="teacher">
                <c:url value="/profileTeacher.do" var="profileUrl">
                    <c:param name="selectedPerson" value="${teacher.idTeacher}"/>
                </c:url>
                <a name="selected" href="${profileUrl}"/><c:out value="${teacher.nameTeacher}"/></a> </br>
            </c:forEach>
        </form>
    </c:if>

    <c:if test="${empty foundData.teachers}" >
        <c:out value="Немає даних про викладачів"/>
    </c:if>

    <input type="submit" value="Додати викладача"/>
    <%--<a name="createTeacher" href="/profileTeacher.do"/><c:out value="Додати викладача"/></a> </br>--%>

</form:form>
</body>
</html>