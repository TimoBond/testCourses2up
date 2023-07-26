<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 18.03.2023
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student delete</title>
</head>
<body>
<form method="post" action="FrontController">
    <input type="hidden" name="command" value="delete_user">
    <input type="text" name="id" value=""><br/>
    <input type="submit" name="delete user">

</form>
</body>
</html>
