<%--
  Created by IntelliJ IDEA.
  User: TTT
  Date: 27.05.2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

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
  <th>Оцінка</th>
  <th>Дата оцінки</th>
  <th>Коментарій</th>
  <th>Оцінка за домашне завдання</th>
  <th>Назва предмету</th>
  <%--<th>delete</th>--%>
  <%--<th>whotche all lecture</th>--%>
  <c:forEach var="grades" items="${lectureGrade.lectureItems}">
    <tr>
      <td>${grades.grade}</td><td>${grades.dateGrade}</td><td>${grades.coment}</td>
      <td>${grades.gradeByStudent}</td><td>${grades.course}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
