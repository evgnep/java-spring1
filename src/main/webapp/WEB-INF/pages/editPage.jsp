<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 21.09.2019
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${user.isNew()}">
        <title>Добавить пользователя</title>
    </c:if>
    <c:if test="${!user.isNew()}">
        <title>Изменить пользователя</title>
    </c:if>
</head>
<body>
<c:if test="${user.isNew()}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!user.isNew()}">
    <c:url value="/update" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!user.isNew()}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">Имя</label>
    <input type="text" name="name" id="name" value="${user.name}">
    <c:if test="${user.isNew()}">
        <input type="submit" value="Добавить">
    </c:if>
    <c:if test="${!user.isNew()}">
        <input type="submit" value="Сохранить">
    </c:if>
</form>
</body>
</html>
