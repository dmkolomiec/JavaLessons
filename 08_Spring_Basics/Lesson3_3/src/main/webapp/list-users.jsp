<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Список</title>
</head>
<body>
<h1>Список користувачів</h1>
<table>
  <thead>
  <tr>
    <th>Ім'я</th>
    <th>Прізвище</th>
    <th>Рік нар.</th>
    <th>Стать</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.name}</td>
      <td>${user.surname}</td>
      <td>${user.birthDate}</td>
      <td>${user.gender ? 'чол' : 'жін'}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p>Всього: ${info.recCount}</p>

</body>
</html>
