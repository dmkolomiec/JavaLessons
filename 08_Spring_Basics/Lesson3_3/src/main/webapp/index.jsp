<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Pass data</title>
</head>
<body>
<h3>Стартова сторінка</h3>
<form id = "start-form1" action="/input-data" method="get">
    <input type="submit" value="Додати">
</form>
<form id="user-form2" action="/list-users" method="get">
    <%--    Кнопка с надписью Pass data, после нажатия которой выполняется передача данных методом Post--%>
    <input type="submit" value="Список">
</form>

</body>
</html>
