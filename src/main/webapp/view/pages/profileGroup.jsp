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

</div>
<form:form method="post" action="/timetable/addGroup.do" commandName="group">
    <form:hidden path="idStudentGroup"/>
    <table>
        <tr>
            <td><form:label path="nameGroup">Назва групи</form:label></td>
            <td><form:input path="nameGroup" name="command.nameGroup" type="text" value="${command.nameGroup}"/></td>
        </tr>

        <tr>
            <td><form:label path="subjects">Предмети</form:label></td>
            <td><form:select path="subjects" type="text" items="${allSubjects}" itemLabel="nameSubject" itemValue="idSubject" multiple="true"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Зберегти зміни"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

