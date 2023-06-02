<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Додавання</title>
</head>
<body>
<%--Помимо атрибутов id, action, method, есть атрибут modelAttribute с параметром user --%>
<%--Это форма, в которую мы будем передавать данные, а эти данные будут сетиться в объект типа User--%>
<form id="user-form3" action="/user/add" method="post" modelAttribute= ${user}>
    <p>Ім'я* <input type = "text" name = "name" required minlength="3"></p>
    <p>Прізвище* <input type = "text" name = "surname"required  minlength="3"></p>
    <p>Д/н* <input type = "date" name = "birthDate" required> </p>
    <p>Стать* ([X]-чол.) :<input type = "checkbox" name = "gender"> </p>
    <p>Телефон* <input type = "tel" name = "phone" required minlength="13" required></p>
    <p>e-mail <input type="email" name="email"></p>

    <%--    Кнопка с надписью Pass data, после нажатия которой выполняется передача данных методом Post--%>
    <input type="submit" value="Зберегти">
</form>
</body>
</html>
