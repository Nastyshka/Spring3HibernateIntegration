<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>Login Page</title>--%>
<%--<style>--%>
<%--.errorblock {--%>
<%--color: #ff0000;--%>
<%--background-color: #ffEEEE;--%>
<%--border: 3px solid #ff0000;--%>
<%--padding: 8px;--%>
<%--margin: 16px;--%>
<%--}--%>
<%--</style>--%>
<%--</head>--%>
<%--<body onload='document.f.j_username.focus();'>--%>
<%--<h3>Login with Username and Password (Custom Page)</h3>--%>

<%--<c:if test="${not empty error}">--%>
<%--<div class="errorblock">--%>
<%--Your login attempt was not successful, try again.<br /> Caused :--%>
<%--${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}--%>
<%--</div>--%>
<%--</c:if>--%>

<%--<form name='f' action=../../j_spring_security_check--%>
<%--method='POST'>--%>

<%--<table>--%>
<%--<tr>--%>
<%--<td>User:</td>--%>
<%--<td><input type='text' name='j_username' value=''>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Password:</td>--%>
<%--<td><input type='password' name='j_password' />--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'><input name="submit" type="submit"--%>
<%--value="submit" />--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'><input name="reset" type="reset" />--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>

<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        <%@include file="/view/css/login.css" %>
        <%@include file="/view/css/index.css" %>
    </style>
</head>
<%--<body onload='document.f.j_username.focus();'>--%>
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

    <div class="form">
    <c:if test="${not empty error}">
        <div class="errorblock">
            Не вдалося увійти. Спробуйте ще раз<br/> Caused :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>

    <form name='f' action=../../j_spring_security_check
          method='POST' class="form_style">
        <div class="form_name">Вхід в систему</div>

        <table class="form_table">
            <tr>
                <td>Користувач:</td>
                <td><input type='text' name='j_username' value='' >
                </td>
            </tr>
            <tr>
                <td>Пароль:</td>
                <td><input type='password' name='j_password' />
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="Увійти" class="form_button"/>
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="reset" type="reset" value="Скинути" class="form_button"/>
                </td>
            </tr>
        </table>

    </form>
    </div>
</div>
<div class="footer">
    Anastsiia Rudyk
</div>
</body>
</html>