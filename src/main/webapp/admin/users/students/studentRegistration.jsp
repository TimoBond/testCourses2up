<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 18.03.2023
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet" type="text/css" href="login1.css">
</head>
<body>
<header>
    <h2 class="logo">Art Master</h2>
    <nav class="navigation">
        <a href="FrontController?command=go_menu_Command&type=home">Home</a>
        <a href="FrontController?command=go_menu_Command&type=courses">Courses</a>
        <a href="FrontController?command=go_menu_Command&type=FAQ">FAQ</a>
        <form  method="post" action="FrontController">
            <input type="hidden" name="command" value="login">
            <button class="btnLogin-popup">Login</button>
        </form>

    </nav>
</header>
    <form class="as" method="post" action="FrontController">
<input type="hidden" name="command" value="REGISTRATION_STUDENT">
    <label >${wrong}</label>
    Name:<br/>
    <input type="text" name="name" value="" required><br/>
    Surname:<br/>
    <input type="text" name="surname" value="" required><br/>
    Login:<br/>
    <input type="text" name="login" required><br/>
    Password<br/>
    <input type="text" name="password" value="" required><br/>
    Mail<br/>
    <input type="email" name="mail" value="" required><br/>
    Phone<br/>
    <input type="text" name="phone" value="" required><br/>
    Course<br/>
    <input type="text" name="course" value="" required><br/>

    <input type="submit" value="registration">
</form>
</body>
</html>
