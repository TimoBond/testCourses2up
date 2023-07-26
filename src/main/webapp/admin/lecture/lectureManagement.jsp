<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 17.03.2023
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="lectur.css">
</head>
<body>

<header >
    <h2 class="logo">Art Master</h2>
    <nav class="navigation">
        <a href="FrontController?command=go_menu_command&type=home">Home</a>
        <a href="FrontController?command=go_menu_command&type=courses">Courses</a>
        <a href="FrontController?command=go_menu_command&type=FAQ">FAQ</a>
        <form  method="post" action="FrontController">
            <input type="hidden" name="command" value="go_registration">
            <button  class="btnLogin-popup " >Кабінет</button>
        </form>
    </nav>
</header>
<table>
    <th>id</th>
    <th>Title</th>
    <th>date start</th>
    <th>date finish</th>
    <th>redact course</th>
    <%--<th>delete</th>--%>
    <%--<th>whotche all lecture</th>--%>
    <c:forEach var="lectures" items="${Lectures}">
        <tr>
            <td class="course">${lectures.id}</td><td>${lectures.course.title}</td><td>${lectures.dateStart}</td><td>${lectures.dateFinish}</td>
            <td>
                <form class="as" method="get"  action="FrontController">
                    <input type="hidden" name="command" value="go_to_course"/>
                    <input type="hidden" name="id" value="${course.id}">
                    <input type="submit" value="Редагувати"/>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>


</body>
</html>
