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

    <div class="main_title">Профайл викладача</div>
</div>

<form:form method="post" action="/timetable/addTeacher.do" commandName="teacher" cssClass="fstyle">
    <form:hidden path="idTeacher"/>
    <table>
        <tr class="title2">
            <td><form:label path="nameUser">ПІБ</form:label></td>
            <td><form:input path="nameUser" name="command.nameUser" type="text" value="${command.nameUser}"/></td>
        </tr>
        <tr class="title2">
            <td><form:label path="eMail">e-mail</form:label></td>
            <td><form:input path="eMail" name="command.eMail" type="text" value="${command.eMail}"/></td>

        </tr>
        <tr class="title2">
            <td><form:label path="telephoneNumber">Номер телефону</form:label></td>
            <td><form:input path="telephoneNumber" name="command.telephoneNumber" type="text"
                            value="${command.telephoneNumber}"/></td>
        </tr>
        <tr class="title2">
            <td><form:label path="subjects">Предмети</form:label></td>
            <td><form:select path="subjects" type="text" items="${allSubjects}" itemLabel="nameSubject" itemValue="idSubject" multiple="true" cssClass="form_selectMult"/></td>
        </tr>

        <tr class="title2">
            <td><form:label path="availableTimeslots">Вільні пари</form:label></td>
            <td><form:select path="availableTimeslots" type="text" items="${allTimeslots}" itemLabel="getDayLesson" cssClass="form_select" itemValue="idTimeSlot" multiple="false">

                </form:select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Зберегти" class="form_button"/>
</form:form>
    </div>
</body>
</html>

