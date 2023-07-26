<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 17.03.2023
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>surname</td>
        <td>mail</td>
        <td>phone</td>
        <td>teacherLvl</td>
        <td>teacherPhoto</td>
        <td>teacherAbout</td>
        <td>teacherExp</td>
        <td>delete</td>
        <td>update</td>
    </tr>
    <c:forEach var="teacher" items="${Users}">
        <tr>
            <td>${teacher.id}</td><td>"${teacher.name}"</td><td>"${teacher.surname}"</td><td>"${teacher.mail}"</td>
            <td>"${teacher.phone}"</td>
            <td>"${teacher.level}"</td>
            <td><img src="resources/images/${teacher.photoFileName}" width="60" alt="no picture"></td>
<%--            <td><img src= "${pageContext.request.contextPath}" width="40" alt="no page"></td>--%>
            <td>"${teacher.about}"</td><td>"${teacher.experience}"</td>2
            <td><a href="FrontController?command=delete_user&id=${teacher.id}&type=teacher">Delete</a></td>
            <td>
                <form method="get"  action="FrontController">
                    <input type="hidden" name="command" value="GO_UPDATE_USER_COMMAND"/>
                    <input type="hidden" name="id" value="${teacher.id}">
                    <input type="submit" value="update"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
