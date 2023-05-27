<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Pass data</title>
</head>
<body>
<%--Помимо атрибутов id, action, method, есть атрибут modelAttribute с параметром user --%>
<%--Это форма, в которую мы будем передавать данные, а эти данные будут сетиться в объект типа User--%>
<form id="user-form" action="/input-data" method="post" modelAttribute= ${user}>
    <p>Ім'я :<input type = "text" name = "name" minlength="3" ma></p>
    <p>Прізвище :<input type = "text" name = "surname" minlength="3"></p>

<%--    <p>Вік :<input type = "number" name = "years" min="14" max="100"></p>--%>
    <p>Д/н :<input type = "date" name = "birthDate" > </p>
    <p>Стать :<input type = "checkbox" name = "gender"> </p>

    <%--    Кнопка с надписью Pass data, после нажатия которой выполняется передача данных методом Post--%>
    <input type="submit" value="Зберегти">
</form>
</body>
</html>
