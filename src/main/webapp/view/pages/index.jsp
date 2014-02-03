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
    <script type='text/javascript' src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js">
        $("input[id=radio]:radio").change(function () {
            alert("LOL!");
        });
    </script>
    <title>Timetable</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        <%@ include file="/view/css/tableStyle.css"%>
    </style>

</head>

<body>
<form:form action="home.do" method="get" commandName="hp" name="hpForm" id="hpForm">
<div id="header">
    <hr>
    <h1><a href="/timetable/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg"
                                                             height="57" width="57"/></a>Інститут післядипломної освіти
        НТУУ КПІ</h1>
    <hr>
</div>

<div id="content">

    <span class="scroll"></span>

    <c:if test="${empty hp.group}">
        <h1>Розклад груп </h1>
    </c:if>

    <c:if test="${not empty hp.group}">
        <h1>Розклад гпупи ${hp.group.nameGroup}</h1>
    </c:if>

    <c:url value="/home2.do" var="profileUrl">
        <%--<c:param name="idTeacher" value="${teacher.idTeacher}"/>--%>
    </c:url>
    <a name="tt" href="${profileUrl}"/>

    <h3><c:out value="Розклад викладачів"/></h3></a> </br>


    <c:if test="${not empty hp.groups}">
        <form:label path="group">Групи</form:label>
        <form:select path="group" type="text" items="${hp.groups}" itemLabel="nameGroup" itemValue="idStudentGroup"
                     multiple="false" title=""/>
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
        <c:if test="${not empty hp.lessons}">
            <c:forEach items="${hp.lessons}" var="lesson">
                <tr>
                    <th scope="row">1 пара<br/> 8.30-10.05</th>
                    <td>
                        <c:if test="${lesson.timeslot.idTimeSlot eq 1}">
                            ${lesson.subject.nameSubject}
                        </c:if>
                        <c:if test="${not (lesson.timeslot.idTimeSlot eq 1)}">
                            -
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${lesson.timeslot.idTimeSlot eq 2}">
                            ${lesson.subject.nameSubject}
                        </c:if>
                        <c:if test="${not (lesson.timeslot.idTimeSlot eq 2)}">
                            -
                        </c:if>
                    </td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tbody>
                <tr>
                    <th scope="row">2 пара<br/> 10.25-12.00</th>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <th scope="row">3 пара<br/> 12.20-13.55</th>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <th scope="row">4 пара<br/> 14.15-15.50</th>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <th scope="row">5 пара<br/> 16.10-17.45</th>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <th scope="row">6 пара<br/> 18.05-19.40</th>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                </tbody>
            </c:forEach>
        </c:if>
    </table>
    </form:form>
</div>

</body>
</html>