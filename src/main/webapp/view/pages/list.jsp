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
        <%@ include file="/view/css/tabs.css"%>
        <%@include file="/view/css/index.css" %>
    </style>
    <title>All info</title>
</head>

<body style="background-image: url(${pageContext.request.contextPath}/view/img/back1.jpg);
        background-attachment: scroll;
        background-position: center;">

<div class="wrapper">
    <div class="header">
        <a class="header_link" href="#">
            <img src="${pageContext.request.contextPath}/view/img/logo.png" class="header_logo" hight="57" width="48">
            <span class="header_title">Інститут післядипломної освіти НТУУ КПІ</span>
        </a>
    </div>

    <%--Subject--%>
    <div style="width: 90%; float: left;">
        <div class="w3c">
            <div id="tab1">
                <a href="#tab1">Список предметів</a>

                <div>
                    <c:if test="${not empty foundData.subjects}">
                    <form>
                        <c:forEach items="${foundData.subjects}" var="subject">
                            <c:url value="/profileSubject.do" var="profileUrl">
                                <c:param name="selectedSubject" value="${subject.idSubject}"/>
                            </c:url>
                            <a name="selected" href="${profileUrl}"/><c:out value="${subject.nameSubject}"/></a> </br>
                        </c:forEach>
                    </form>
                    </c:if>

                    <c:if test="${empty foundData.subjects}">
                        <c:out value="Немає даних про предмети"/>
                    </c:if>

                    <form action="/timetable/profileSubject.do" method="get">
                        <input type="submit" value="Додати" class="form_button"/>
                    </form>
                </div>
            </div>

            <%--Group--%>
            <div id="tab2">
                <a href="#tab2">Список груп</a>

                <div>
                    <c:if test="${not empty foundData.groups}">
                    <form>
                        <c:forEach items="${foundData.groups}" var="group">
                            <c:url value="/profileGroup.do" var="profileUrl">
                                <c:param name="selectedGroup" value="${group.idStudentGroup}"/>
                            </c:url>
                            <a name="selected" href="${profileUrl}"/><c:out value="${group.nameGroup}"/></a> </br>
                        </c:forEach>
                    </form>
                    </c:if>

                    <c:if test="${empty foundData.groups}">
                        <c:out value="Немає даних про групи"/>
                    </c:if>

                    <form:form action="/timetable/profileGroup.do" method="get">
                        <input type="submit" value="Додати" class="form_button"/>
                    </form:form>
                </div>
            </div>

            <%--Classroom--%>
            <div id="tab3">

                <a href="#tab3">Список аудиторій</a>

                <div>
                    <c:if test="${not empty foundData.classrooms}">
                    <%--<form>--%>
                        <c:forEach items="${foundData.classrooms}" var="classroom">
                            <c:url value="/profileClassroom.do" var="profileUrl">
                                <c:param name="selectedClassroom" value="${classroom.idClassroom}"/>
                            </c:url>
                            <a name="selected" href="${profileUrl}"/><c:out value="${classroom.number}"/></a> </br>
                        </c:forEach>
                    <%--</form>--%>
                    </c:if>

                    <c:if test="${empty foundData.classrooms}">
                        <c:out value="Немає даних про аудиторії"/>
                    </c:if>

                    <form action="/timetable/profileClassroom.do" method="GET">
                        <input type="submit" value="Додати" class="form_button"/>
                    </form>
                </div>
            </div>

            <%--Teacher--%>
            <div id="tab4">

                <a href="#tab4">Список вчителів</a>

                <div>
                    <c:if test="${not empty foundData.teachers}">
                    <form>
                        <c:forEach items="${foundData.teachers}" var="teacher">
                            <c:url value="/profileTeacher.do" var="profileUrl">
                                <c:param name="idTeacher" value="${teacher.idTeacher}"/>
                            </c:url>
                            <a name="selected" href="${profileUrl}"/><c:out value="${teacher.nameUser}"/></a> </br>
                        </c:forEach>
                    </form>
                    </c:if>

                    <c:if test="${empty foundData.teachers}">
                        <c:out value="Немає даних про викладачів"/>
                    </c:if>
                    <form:form action="/timetable/profileTeacher.do" method="get">
                        <input type="submit" value="Додати" class="form_button"/>
                    </form:form>
                </div>
            </div>

            <%--Timeslot--%>
            <div id="tab5">

                <a href="#tab5">Заняття</a>

                <div>
                    <c:if test="${not empty foundData.timeSlots}">
                    <form>
                        <c:forEach items="${foundData.timeSlots}" var="timeslot">
                            <c:url value="/profileTimeslot.do" var="profileUrl">
                                <c:param name="selectedTimeslot" value="${timeslot.idTimeSlot}"/>
                            </c:url>
                            <a name="selected"
                               href="${profileUrl}"/>${timeslot.dayOfWeek}-${timeslot.lessonNumber}</a> </br>
                        </c:forEach>
                    </form>
                    </c:if>

                    <c:if test="${empty foundData.timeSlots}">
                        <c:out value="Немає даних про розклад"/>
                    </c:if>
                    <form:form action="/timetable/profileTimeslot.do" method="get">
                        <input type="submit" value="Додати" class="form_button"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <div>
        <form:form action="/timetable/generate.do" method="get">
            <br/>
            <input type="submit" value="Розклад" class="form_button"/>
        </form:form>
    </div>
</div>
<div class="footer">
    Anastasiia Rudyk
</div>
</body>
</html>