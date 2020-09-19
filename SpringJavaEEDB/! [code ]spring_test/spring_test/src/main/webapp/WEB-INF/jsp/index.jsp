<%--
  Created by IntelliJ IDEA.
  User: dakon
  Date: 04.02.2018
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <title>My first Spring App</title>
</head>
<body>
    <p>Counter - ${counter}</p>
    <p>ConstructorCounter - ${constructorCounter}</p>

    <c:forEach var="user" items="${users}">
        ${user} <br/>
    </c:forEach>

    <table border="1">
        <tr>
            <th>Идентификатор</th>
            <th>Имя</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
