<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 08.03.2023
  Time: 16:48
  To change this template use File | Settings | File Templates.

  hidden -  спрятаный и не видемый в веб страничке параметр
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" type="text/css" href="login1.css">
</head>
<body>



<header >
    <h2 class="logo">Art Master</h2>
    <nav class="navigation">
        <a href="FrontController?command=go_menu_command&type=home">Home</a>
        <a href="FrontController?command=COMMAND_COURSES_MANAGEMENT">Courses</a>
        <a href="FrontController?command=go_menu_command&type=FAQ">FAQ</a>
        <form  method="post" action="FrontController">
            <input type="hidden" name="command" value="go_registration">
        <button  class="btnLogin-popup " >Registration</button>
        </form>
    </nav>
</header>
<form class="as" method="post" action="FrontController">
    <input type="hidden" name="command" value="login"/>
    <h2> Login </h2>
    Login:<br/>
    <input type="text" name="login" value="${user.login}" required> <br/>
    Password:<br/>
    <input type="password" name="password" value="${user.password}" required> <br/>
    ${wrongLoginPassword}<br/>
    <input type="submit" value="log in"/>
    <a href="FrontController?command=go_registration">registration</a>
</form>

</body>
</html>
