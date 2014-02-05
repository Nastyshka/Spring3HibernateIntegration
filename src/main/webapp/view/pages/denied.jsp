<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<h1 id="banner">Неавторизований доступ</h1>

<hr />

<c:if test="${not empty error}">
    <div style="color:red">
        Ви ввели не правильний логін або пароль<br />
        <%--Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}--%>
    </div>
</c:if>

<p class="message">Немає доступу</p>
<a href="/timetable/login.do">Повернутись на сторінку авторизації</a>
</body>
</html>