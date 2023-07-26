<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 06.06.2023
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get"  action="FrontController">
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>surname</td>
        <td>grade</td>
        <td>dateGrade</td>
        <td></td>
    </tr>
    <c:forEach var="LectureItem" items="${lectureItems}">
        <tr>
            <td>${LectureItem.student.id}</td><td>${LectureItem.student.name}</td><td>${LectureItem.student.surname}</td>
            <td><input type="number" max="10" name="grade" value="${LectureItem.grade}"></td>
            <td><input type="text" name="date" value="${LectureItem.dateGrade}"></td>
        </tr>
    </c:forEach>
<c:if test="${not empty dateFinish}">
        <input type="hidden" name="command" value="UP_GRADES_STUDENT"/>
    <input type="hidden" name="lectureItems" value="${lectureItems}"/>
    <input type="hidden" name="id" value="${id}"/>
        <input type="submit" value="поставити оцінки"/>

</c:if>
</table>
</form>
</body>
</html>
