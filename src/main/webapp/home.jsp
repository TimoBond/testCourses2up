<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 19.05.2023
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="login1.css">
</head>
<body>
<header >
    <h2 class="logo">Art Master</h2>
    <nav class="navigation">
        <a href="FrontController?command=go_menu_command&type=home">Home</a>
        <a href="FrontController?command=go_menu_command&type=">Courses</a>
        <a href="FrontController?command=go_menu_command&type=FAQ">FAQ</a>
        <form  method="post" action="FrontController">
            <input type="hidden" name="command" value="login">
            <button class="btnLogin-popup">Login</button>
        </form>
        <form  method="post" action="FrontController">
            <input type="hidden" name="command" value="go_registration">
            <button  class="btnLogin-popup " >Registration</button>
        </form>
    </nav>
</header>

</body>
</html>
