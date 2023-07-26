<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 06.06.2023
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>title</td>
        <td>date start</td>
        <td>date finish</td>
        <td>start</td>
    </tr>
    <c:forEach var="Lectures" items="${Lectures}">
        <tr>
            <td>${Lectures.id}</td><td>${Lectures.course.title}</td><td>${Lectures.dateStart}</td><td>${Lectures.dateFinish}</td>
            <td>
                <form method="get"  action="FrontController">
                    <input type="hidden" name="command" value="students_by_lecture"/>
                    <input type="hidden" name="id" value="${Lectures.id}">
                    <input type="hidden" name="dateFinish" value="${Lectures.dateFinish}">
                    <input type="submit" value="поставити оцінки"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
