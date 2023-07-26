<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 29.03.2023
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="FrontController">
    <input type="hidden" name="command" value="registration_student">
    Name:<br/>
    <input type="text" name="name" value=""> <br/>
    ${}
    Surname<br/>
    <input type="text" name="surname" value="">
    ${}
    Login <br/>
    <input type="text" name="login" value=""> <br/>
    ${}
    Password:<br/>
    <input type="text" name="password" value=""> <br/>
    ${}
    Mail:<br/>
    <input type="text" name="mail" value=""> <br/>
    ${}
    Phone:<br/>
    <input type="text" name="phone" value=""> <br/>
    ${}
    Course<br/>
    <input type="text" name="course" value=""><br/>
    ${}
    <input type="submit" name="registration"><br/>

    <input type="reset" name="clear">
</form>
<a href="FrontController?command=logout">log out</a>
</body>
</html>
