<%--
  Created by IntelliJ IDEA.
  User: upgrademac
  Date: 16.04.2023
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>
&nbsp;
<a href="FrontController?command=logout" > login out</a>
${wrongUp}<br/>
<form method="post" action="FrontController">
    <input type="hidden" name="command" value="update_users_command">
    <input type="text" name="name" value="${selectedUser.name}" required><br/>
    <input type="text" name="surname" value="${selectedUser.surname}" required><br/>
    <input type="text" name="login" value="${selectedUser.login}" required><br>
    <input type="text" name="password" value="${selectedUser.password}" required><br/>
    <input type="email" name="mail" value="${selectedUser.mail}" required><br/>
    <input type="text" name="phone" value="${selectedUser.phone}" required><br/>
    <input type="text" name="teacherLevel" value="${selectedUser.level}" required><br/>
    <input type="text" name="about" value="${selectedUser.about}" required><br/>
    <input type="text" name="experience" value="${selectedUser.experience}" required><br/>
<%--    <input type="hidden" name="type" value="${selectedUser.type}">--%>
    <img src="resources/images/${selectedUser.photoFileName}" width="150" alt="no picture">
    <input type="submit" name="update"  value="update">
</form>
<form method="post" action="UploadController" enctype="multipart/form-data">
    <input type="file" name="picture" value="upload" accept="image/jpeg"><br/>
    <input type="submit" name="delete_photo" value="delete"/>
    <input type="submit" name="upload_photo" value="upload"/>
</form>
</body>
</html>
