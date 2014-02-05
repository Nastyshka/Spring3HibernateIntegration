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
        <%@include file="/view/css/index.css" %>
    </style>

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

<form:form action="home2.do" method="get" commandName="hp" name="hpForm" id="hpForm">
<div id="content">

    <span class="scroll"></span>

    <c:if test="${empty hp.teacher}">
    <div class="main_title">Розклад викладачів </div>
    </c:if>

    <c:if test="${not empty hp.teacher}">
    <div class="main_title">Розклад викладача ${hp.teacher.nameUser}</div>
    </c:if>

    <c:url value="/home.do" var="profileUrl">
    </c:url>
    <a name="tt" href="${profileUrl}"/><div class="title2"><c:out  value="Розклад груп студентів"/></div></a>

    <div class="fstyle">
    <c:if test="${not empty hp.teachers}">
        <form:label path="teacher">Викладачі</form:label>
        <form:select path="teacher" type="text" items="${hp.teachers}" itemLabel="nameUser" itemValue="idTeacher" multiple="false"
                     cssClass="form_select" title=""/>
    </c:if>
    <input type="submit" value="Знайти" class="form_button">
    </div>

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
        <th scope="row">1 пара<br/> 8.30-10.05</th>
        <td>
            <c:if test="${not empty hp.lessons}">
                <c:forEach items="${hp.lessons}" var="lesson">
                    <c:if test="${lesson.timeSlot.idTimeSlot eq 1}">
                        ${lesson.subject.nameSubject}
                    </c:if>
                </c:forEach>
            </c:if>
        </td>
        <td>
            <c:if test="${not empty hp.lessons}">
                <c:forEach items="${hp.lessons}" var="lesson">
                    <c:if test="${lesson.timeSlot.idTimeSlot eq 2}">
                        ${lesson.subject.nameSubject}  <br/>
                        ${lesson.classroom.number}
                    </c:if>
                </c:forEach>
            </c:if>
        </td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 3}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if>
        </td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 4}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if>
        </td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 5}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if>
        </td>
    </tr>
    <tbody>
    <tr>
        <th scope="row">2 пара<br/> 10.25-12.00</th>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 6}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 7}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 8}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 9}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 10}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
    </tr>
    <tr>
        <th scope="row">3 пара<br/> 12.20-13.55</th>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 11}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 12}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 13}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 14}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 15}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
    </tr>
    <tr>
        <th scope="row">4 пара<br/> 14.15-15.50</th>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 16}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 17}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 18}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 19}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 20}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
    </tr>
    <tr>
        <th scope="row">5 пара<br/> 16.10-17.45</th>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 21}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 22}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 23}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 24}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 25}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
    </tr>
    <tr>
        <th scope="row">6 пара<br/> 18.05-19.40</th>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 26}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 27}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 28}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 29}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
        <td><c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <c:if test="${lesson.timeSlot.idTimeSlot eq 30}">
                    ${lesson.subject.nameSubject}  <br/>
                    ${lesson.classroom.number}
                </c:if>
            </c:forEach>
        </c:if></td>
    </tr>
    <tr>
    </tbody>
    </table>
    </form:form>
</div>
</div>

</body>
</html>