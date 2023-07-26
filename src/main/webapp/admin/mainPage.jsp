<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 08.03.2023
  Time: 16:42
  To change this template use File | Settings | File Templates.

  ? - Параматры после него перечисляються
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="style1.css">
<html>
<head>
    <title>Admin main page</title>
</head>
<body>
<h1>Admin`s page</h1><br/>
<h2>Users management</h2>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="FrontController?command=FIND_USER_BY_TYPE&userType=student"> Sudentes management </a><br>
<a href="FrontController?command=find_user_by_type&userType=teacher">Teacher management</a><br/>
<a> Знайти корстувачів</a><br/>

<h2>Courses management</h2>
<a href="FrontController?command=COMMAND_COURSES_MANAGEMENT">Courses management</a><br/>


<h2>Lectures managemt</h2>
<a href="FrontController?command=LECTURE_COMMAND">Lectures management</a><br/>
    <a>Знайти лекції</a>
<a href="FrontController?command=logout" > login out</a>

<%--гипер сылка--%>

</body>
</html>
