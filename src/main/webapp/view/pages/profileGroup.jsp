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
<style>

</style>
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

    </div>
    <form:form method="post" action="/timetable/addGroup.do" commandName="group">
        <form:hidden path="idStudentGroup"/>
        <table>
            <tr>
                <td><form:label path="nameGroup">Назва групи</form:label></td>
                <td><form:input path="nameGroup" name="command.nameGroup" type="text"
                                value="${command.nameGroup}"/></td>
            </tr>

            <tr>
                <td><form:label path="subjects">Предмети</form:label></td>
                <td><form:select path="subjects" type="text" items="${allSubjects}" itemLabel="nameSubject"
                                 itemValue="idSubject" multiple="true"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Зберегти зміни" class="form_button"/>
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

