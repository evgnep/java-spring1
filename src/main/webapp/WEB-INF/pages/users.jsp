<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 21.09.2019
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Пользователи</h2>
<table>
    <tr>
        <th>id</th>
        <th>Имя</th>
        <th>Действия</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>
                <a href="/edit/${user.id}">Редактировать</a>
                <a href="/delete/${user.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Добавить</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Добавить нового пользователя</a>
</body>
</html>
