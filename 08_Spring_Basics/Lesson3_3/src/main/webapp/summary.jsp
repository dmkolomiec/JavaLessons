<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Summary</title>
</head>
<body>
<h4>Додано користувача</h4>
<%--Здесь мы доступаемся до полей нашего user--%>
<p>Ім'я : ${user.name} </p>
<p>Прізвище : ${user.surname}</p>
<%--<h4>Вік : ${user.years}</h4>--%>
<p>Дата нар. : ${user.birthDate}</p>
<p>Стать : ${user.gender ? 'чол' : 'жін'}</p>

<h4>Статистика</h4>
<p>Всього додано: ${info.recCount}</p>

<%--<form id="user-form2" action="/list-users" method="get" modelAttribute= ${users}>--%>
<form id="user-form2" action="/list-users" method="get">
    <%--    Кнопка с надписью Pass data, после нажатия которой выполняется передача данных методом Post--%>
    <input type="submit" value="Список">
</form>
<form id="user-form3" action="/input-data" method="get">
    <%--    Кнопка с надписью Pass data, после нажатия которой выполняется передача данных методом Post--%>
    <input type="submit" value="Додати">
</form>
</body>
</html>
