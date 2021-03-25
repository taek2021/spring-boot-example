<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<h5>Sign-in</h5>
<%--<form action="${pageContext.request.contextPath}/sign-in/process" method="post">--%>
<%--    <label>name:</label><br>--%>
<%--    <input type="text" name="name"><br>--%>
<%--    <label>password:</label><br>--%>
<%--    <input type="password" name="password"><br>--%>
<%--    <input type="submit" value="sign-in">--%>

<%--</form>--%>
    <form:form action="${pageContext.request.contextPath}/sign-in/process" method="post" modelAttribute="memberDto">
        <form:label path="name">name:</form:label><br>
        <form:input path="name" type="text"/><br>
        <form:label path="password">password:</form:label>
        <form:input path="password" type="password"/><br>
        <input type="submit" value="sign-in">
    </form:form>
    <a href="${pageContext.request.contextPath}/registration">registration</a>

    </div>
</body>
</html>
