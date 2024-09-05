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
    <title>등록</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <div style="margin: 5px">
            <input type="text", name="title" placeholder="INSERT TITLE" required/>
        </div>
        <div style="margin: 5px">
            <input type="date", name="dueDate" required/>
        </div>
        <div style="margin: 5px">
            <button type="reset">RESET</button>
            <button type="submit">REGISTER</button>
        </div>
    </form>
</body>
</html>
