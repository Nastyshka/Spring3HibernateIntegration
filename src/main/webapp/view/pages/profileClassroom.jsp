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
<div id="content">
    <a class="back" href=""></a>
    <span class="scroll"></span>

    <h1>Аудиторія</h1>

</div>
<form:form method="post" action="/timetable/addClassroom.do" commandName="classroom">
    <form:hidden path="idClassroom"/>
    <table>
        <tr>
            <td><form:label path="number">Номер аудиторії</form:label></td>
            <td><form:input path="number" name="classroom.number" type="text" value="${command.number}"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Адреса</form:label></td>
            <td><form:input path="address" name="classroom.address" type="text" value="${command.address}"/></td>
        </tr>
        <tr>
            <td><form:label path="type">Кількість місць</form:label></td>
            <td><form:input path="type" name="classroom.size" type="text" value="${command.size}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Зберегти"/>
            </td>
        </tr>
    </table>

</form:form>
    </div>
<div class="footer">
    Anastasiia Rudyk
</div>
</body>
</html>

