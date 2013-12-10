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

    <h1>Додати новий предмет</h1>

</div>
<form:form method="post" action="/timetable/addSubject.do">

    <table>
        <tr>
            <td><form:label path="nameSubject">Назва предмету</form:label></td>
            <td><input name="command.nameSubject" type="text" value="${command.nameSubject}"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Опис</form:label></td>
            <td><input name="command.description" type="text" value="${command.description}"/></td>
        </tr>
        <tr>
            <td><form:label path="amountLections">Кількість лекцій</form:label></td>
            <td><input name="command.amountLections" type="text" value="${command.amountLections}"/></td>
        </tr>
        <tr>
            <td><form:label path="amountPractices">Кількість практичних занять</form:label></td>
            <td><input name="command.amountPractices" type="text" value="${command.amountPractices}"/></td>
        </tr>
        <tr>
            <td><form:label path="amountLaboratory">Кількість лабораторних занять</form:label></td>
            <td><input name="command.amountLaboratory" value="${command.amountLaboratory}" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Додати предмет"/>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>

