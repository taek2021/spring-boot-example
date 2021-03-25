<%--
  Created by IntelliJ IDEA.
  User: ptj97
  Date: 2021-03-18
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>Sigh-up</h5><br>
<form action="${pageContext.request.contextPath}/registration/process" method="post">
<%--    회원가입정보를 보내는것이니까 post 메소드로--%>
    <label>ID:</label><br>
    <input type="text" name="name"><br>
    <label>PW:</label><br>
    <input type="password" name="password"><br>
    <input type="submit" value="register">

</form>
</body>
</html>
