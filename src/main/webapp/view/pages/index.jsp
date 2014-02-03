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
 <form:form action="home.do" method="post" commandName="hp" name="hpForm" id="hpForm">
 <div id="header">
     <hr>
     <h1><a href="/timetable/home.do" title="Start page"><img src="${pageContext.request.contextPath}/view/img/logo.jpg" height="57" width="57"/></a>Інститут післядипломної освіти НТУУ КПІ</h1>
     <hr>
 </div>

 <div id="content">

 <span class="scroll"></span>

 <h1>Розклад</h1>

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

     <c:if test="${empty hp.groups && empty hp.teachers}">
         <input type="radio" name="type" value="G" id="radio"/>
            Група
        <input type="radio" name="type" value="T" id="radio"/>
            Викладач
    </c:if>

    <c:if test="${not empty hp.groups}">
        <form:label path="group">Групи</form:label>
        <form:select path="group" type="text" items="${hp.groups}" itemLabel="nameGroup" itemValue="idStudentGroup" multiple="false"/>
    </c:if>
    <c:if test="${not empty teachers}">
        <form:label path="teacher">Викладачі</form:label>
        <form:select path="teacher" type="text" items="${hp.teachers}" itemLabel="nameUser" itemValue="idTeacher" multiple="false" title=""/>
    </c:if>

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