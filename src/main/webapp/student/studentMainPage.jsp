<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 08.03.2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student main page</title>
</head>
<body>
<head>
    <title>Professor main page</title>
    <h2>Users management</h2>
    &nbsp;&nbsp;&nbsp;&nbsp;<a>${User.id}</a>
    <a href="FrontController?command=FIND_USER_BY_TYPE&userType=student"> Особистий кабінет </a><br>
    <form method="get"  action="FrontController">
        <input type="hidden" name="command" value="GRADE_COMMAND"/>
        <input type="hidden" name="id" value="${User.id}">
        <input type="submit" value="Мій щоденик"/>
    </form>
    <a href="FrontController?command=find_user_by_type&userType=teacher">Налаштування</a>

    <h2>Courses management</h2>
    <a href="FrontController?command=COMMAND_COURSES_MANAGEMENT">Курси</a><br/>


    <h2>Lectures managemt</h2>
    <a href="http://localhost:8080/courses1_war_exploded/admin/lecture/lectureManagement.jsp">Інформація</a><br/>
    <a href="FrontController?command=find_user_by_type&userType=teacher">Домашні завдання</a>
    <a href="FrontController?command=logout" > login out</a>
</body>
</html>
