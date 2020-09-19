<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11.09.2020
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Autor MUDAK</title>
</head>
<body>


    <table>
        <tr>
            <td>Идентификатор</td>
            <td>Имя</td>
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
