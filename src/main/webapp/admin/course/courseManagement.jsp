<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 17.03.2023
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources1/cour.css">
<%--    <link rel="stylesheet" type="text/css" href="style1.css">--%>
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
     <th>Title</th>
     <th>Cover</th>
     <th>duration</th>
     <th>description</th>
     <th>Professor</th>
     <th>redact course</th>
<%--<th>delete</th>--%>
<%--<th>whotche all lecture</th>--%>
<c:forEach var="course" items="${Courses}">
    <tr>
   <td class="course">${course.title}</td><td><img src="resources/images/${course.coverFileName}" width="200" alt="no picture"></td><td>${course.duration}<a>"Скільки годин йде курс"</a></td><td>${course.description}</td>
        <td>${course.professor.name}</td>
        <td>
        <form class="as" method="get"  action="FrontController">
            <input type="hidden" name="command" value="go_to_course"/>
            <input type="hidden" name="id" value="${course.id}">
            <input type="submit" value="Дізнатиcя більше"/>
        </form>
    </td>

     </tr>
</c:forEach>
 </table>
<a href="http://localhost:8080/courses1_war_exploded/admin/mainPaig.jsp">Return</a>
</body>
</html>
