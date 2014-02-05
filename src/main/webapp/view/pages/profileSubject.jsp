<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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

    <h1>Додати новий предмет</h1>

</div>
<form:form method="post" action="/timetable/addSubject.do" commandName="subject">

    <table>
        <form:hidden path="idSubject"/>
            <td><form:label path="nameSubject">Назва предмету</form:label></td>
            <td><form:input path="nameSubject" name="command.nameSubject" type="text" value="${subject.nameSubject}"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Опис</form:label></td>
            <td><form:input path="description" name="command.description" type="text" value="${subject.description}"/></td>
        </tr>
        <tr>
            <td><form:label path="amountLections">Кількість лекцій</form:label></td>
            <td><form:input path="amountLections" name="command.amountLections" type="text" value="${subject.amountLections}"/></td>
        </tr>
        <tr>
            <td><form:label path="amountPractices">Кількість практичних занять</form:label></td>
            <td><form:input path="amountPractices" name="command.amountPractices" type="text" value="${subject.amountPractices}"/></td>
        </tr>
        <tr>
            <td><form:label path="amountLaboratory">Кількість лабораторних занять</form:label></td>
            <td><input:input path="amountLaboratory" name="command.amountLaboratory" value="${subject.amountLaboratory}" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Зберегти предмет"/>
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

