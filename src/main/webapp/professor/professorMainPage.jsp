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
    <title>Professor main page</title>
    <h2>Users management</h2>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="FrontController?command=FIND_USER_BY_TYPE&userType=student"> Sudentes management </a><br>
    <a href="FrontController?command=find_user_by_type&userType=teacher">Особистий кабінет</a><br/>
    <a href="FrontController?command=find_user_by_type&userType=teacher"> Знайти студента</a><br/>
    <a href="FrontController?command=find_user_by_type&userType=teacher">Налаштування</a>
    <h2>Courses management</h2>
    <a href="FrontController?command=COMMAND_COURSES_MANAGEMENT">Courses management</a><br/>


    <h2>Lectures managemt</h2>
    <a href="http://localhost:8080/courses1_war_exploded/admin/lecture/lectureManagement.jsp">Lectures management</a><br/>
    <a href="FrontController?command=new_grade_command">Знайти лекції</a>
    <a href="FrontController?command=logout" > login out</a>
</head>
<body>

</body>
</html>
