<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 17.03.2023
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>
<%--<a href="http://localhost:8080/courses1_war_exploded/admin/users/students/studentRegistration.jsp">Registration student</a><br/>--%>
<%--<a href="http://localhost:8080/courses1_war_exploded/admin/users/students/studentSearch.jsp">Student search</a><br/>--%>
<%--<a href="http://localhost:8080/courses1_war_exploded/admin/users/students/studentDelete.jsp">Student delete</a><br/>--%>
<%--<a href="http://localhost:8080/courses1_war_exploded/admin/users/students/studentAllFiand.jsp">All student</a><br/>--%>
<%--<a href="http://localhost:8080/courses1_war_exploded/admin/usersManagement.jsp">Return</a>--%>
<form method="post" action="FrontController">
    <input type="hidden" name="command" value="SEARCH_GRADE_STUDENT"/>
    Search student grades<br/>
    Corse:<br/>
    <input type="text" name="nameCourse" value=""> <br/>
    Name:<br/>
    <input type="text" name="name" value=""> <br/>
    Surname:<br/>
    <input type="text" name="surname" value=""> <br/>
    <input type="submit" value="Search student grades"/>
</form>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>surname</td>
        <td>mail</td>
        <td>phone</td>
        <td>student course</td>
        <td>Щоденик</td>
    </tr>
    <c:forEach var="student" items="${Users}">
        <tr>
    <td>"${student.id}"</td><td>"${student.name}"</td><td>"${student.surname}"</td><td>"${student.mail}"</td>
            <td>"${student.phone}"</td><td>"${student.course}"</td>
            <
            <td>
                <form method="get"  action="FrontController?type=student">
                    <input type="hidden" name="command" value="update_user_command"/>
                    <input type="submit" value="Щоденик"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
${wrong}<br/>

<a href="FrontController?command=go_registration">registration</a>
<a href="FrontController?command=logout" > login out</a>
</body>
</html>
