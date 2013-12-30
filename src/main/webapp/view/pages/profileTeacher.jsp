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

    <h1>Створити профайл викладача</h1>
</div>

<form:form method="post" action="/timetable/addTeacher.do" commandName="teacher">
    <form:hidden path="idTeacher"/>
    <table>
        <tr>
            <td><form:label path="nameUser">ПІБ</form:label></td>
            <td><form:input path="nameUser" name="command.nameUser" type="text" value="${command.nameUser}"/></td>
        </tr>
        <tr>
            <td><form:label path="eMail">e-mail</form:label></td>
            <td><form:input path="eMail" name="command.eMail" type="text" value="${command.eMail}"/></td>

        </tr>
        <tr>
            <td><form:label path="telephoneNumber">Номер телефону</form:label></td>
            <td><form:input path="telephoneNumber" name="command.telephoneNumber" type="text"
                            value="${command.telephoneNumber}"/></td>
        </tr>
        <tr>
            <td><form:label path="subjects">Предмети</form:label></td>
            <td><form:select path="subjects" name="command.subjects" type="text" items="${allSubjects}" itemLabel="nameSubject"/></td>
        </tr>
    </table>
    <input type="submit" value="Зберегти"/>
</form:form>
</body>
</html>

