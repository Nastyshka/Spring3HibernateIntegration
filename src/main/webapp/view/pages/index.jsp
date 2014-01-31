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
<html>
<head>
    <title>Timetable</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="Pimp your tables with CSS3" />
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

    <input type="radio" name="type" value="group" checked>
        Група
    <input type="radio" name="type" value="teacher">
        Викладач

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

</div>

</body>
</html>