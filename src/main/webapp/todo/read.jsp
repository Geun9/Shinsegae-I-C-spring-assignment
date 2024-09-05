<%--
  Created by IntelliJ IDEA.
  User: jieunlee
  Date: 2024. 9. 4.
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>조회</title>
    <style>
      div {
        margin: 10px;
      }

      span {
        display: inline-block;
        width: 100px;
      }
    </style>
</head>
<body>
<div>
    <div>
        <span>ID: </span>
        <input type="text" name="id" value="${dto.id}" readonly/>
    </div>
    <div>
        <span>TITLE: </span>
        <input type="text" id="title" value="${dto.title}" readonly/>
    </div>
    <div>
        <span>DUE_DATE: </span>
        <input type="date" id="dueDate" value="${dto.dueDate}" readonly/>
    </div>
    <div>
        <span>FINISHED: </span>
        <input type="checkbox" id="finished"
               value="${dto.finished}" ${dto.finished ? 'checked' : ''} onClick="return false;"/>
    </div>
</div>
<div>
    <a href="/todo/modify?id=${dto.id}">Modify/Remove</a>
    <a href="/todo/list">list</a>
</div>
</body>
</html>
