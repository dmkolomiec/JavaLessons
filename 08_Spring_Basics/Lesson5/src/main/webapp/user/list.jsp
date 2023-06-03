<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Список</title>
</head>
<body>
<h3>Список користувачів</h3>
<table border="1" >
<thead>
  <tr>
    <th>Id</th>
    <th>Ім'я</th>
    <th>Прізвище</th>
    <th>Рік нар.</th>
    <th>Стать</th>
    <th>Телефон</th>
    <th>e-mail</th>
    <th>Дії</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.userId}</td>
      <td>${user.name}</td>
      <td>${user.surname}</td>
      <td>${user.birthDate}</td>
      <td>${user.gender ? 'чол' : 'жін'}</td>
      <td>${user.phone}</td>
      <td>${user.email}</td>
      <td>
        <a href="/user/update=${user.userId}">Редагувати</a>/
        <a href="/user/delete=${user.userId}">Видалити</a>
      </td>

    </tr>
  </c:forEach>
  </tbody>
</table>
<p>Разом: ${info.count}</p>
<form id = "start-form2" action="/user/add" method="get">
  <input type="submit" value="Додати ще">
</form>

<h3>Фільтри</h3>
<p> <a href="/user/list">Всі</a></p>
<p> <a href="/user/list1">Тільки жінки</a></p>

<form method="post" action="/user/list2">
  <p><input title="З" name="date1" type="date"></p>
  <p><input title="по" name="date2" type="date"></p>
<%--  <p> <a href="/user/list2">За датами народження</a></p>--%>
  <p><input type="submit" value="За датами народження"></p>
</form>



</body>
</html>
