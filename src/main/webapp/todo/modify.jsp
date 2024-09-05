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
    <title>수정</title>
    <style>
      div {
        margin: 10px;
      }

      span {
        display: inline-block;
        width: 100px;
      }

      div > button {
        width: 100px;
      }
    </style>
    <script>
      function updateCheckboxValue() {
        const checkbox = document.getElementById('finished-checkbox');
        const finished = document.getElementById('finished');

        console.log('checkbox1: ' + checkbox.checked);
        console.log('finished1: ' + finished.value);

        if (checkbox.checked) {
          finished.value = true;
        } else {
          finished.value = false;
        }

        console.log('checkbox2: ' + checkbox.checked);
        console.log('finished2: ' + finished.value);
      }
    </script>
</head>
<body>
<form method="post">
    <div>
        <span>ID: </span>
        <input type="text" name="id" value="${dto.id}" readonly/>
    </div>
    <div>
        <span>TITLE: </span>
        <input type="text" name="title" value="${dto.title}" required/>
    </div>
    <div>
        <span>DUE_DATE: </span>
        <input type="date" name="dueDate" value="${dto.dueDate}" required/>
    </div>
    <div>
        <span>FINISHED: </span>
        <input type="checkbox" id="finished-checkbox" name="finished-checkbox" ${dto.finished ? 'checked' : ''} onclick="updateCheckboxValue()"/>
        <input type="hidden" id="finished" name="finished" value="${dto.finished ? 'true' : 'false'}">
    </div>
    <div>
        <div>
            <button type="submit" formaction="/todo/modify">Modify</button>
        </div>
        <div>
            <button type="submit" formaction="/todo/remove?id=${dto.id}">Remove</button>
        </div>
    </div>

</form>
</body>
</html>
