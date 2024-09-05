<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jieunlee
  Date: 2024. 9. 4.
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>목록</title>
</head>
<body>
    <h1>Todo List</h1>
<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li><a href="http://localhost:8070/todo/read?id=${dto.getId()}">${dto.getId()}</a> ... ${dto.title} ... ${dto.finished == true ? "DONE" : "NOT YET"}</li>
    </c:forEach>
</ul>
</body>
</html>
