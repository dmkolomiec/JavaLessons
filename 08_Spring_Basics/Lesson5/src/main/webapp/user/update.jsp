<%--<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Оновлення</title>
</head>
<body>

<form id="user-form" action="/user/update" method="post" modelAttribute="${user}">
<%--    При отсутствии этого поля при обновлении будет добаляться новая запись--%>
    <input type="hidden" name="userId" value="${user.userId}"/>
    <p>Id: ${user.userId}</p>

    <p>Ім'я* <input type="text" name="name" value="${user.name}" required minlength="3"></p>
    <p>Прізвище* <input type="text" name="surname" value="${user.surname}" required minlength="3"></p>
    <p>Д/н* <input type="date" name="birthDate" value="${user.birthDate}" required/></p>
    <p>Стать* ([X]-чол.) :<input type="checkbox" name="gender" checked="${user.gender}"/></p>
    <p>Телефон* <input type="tel" name="phone" value="${user.phone}" required minlength="13"></p>
    <p>e-mail <input type="email" name="email" value="${user.email}"></p>
    <input type="submit" value="Оновити">
</form>

</body>
</html>