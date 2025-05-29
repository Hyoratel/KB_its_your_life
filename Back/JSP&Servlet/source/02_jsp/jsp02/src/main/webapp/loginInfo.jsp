<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 결과</title>
</head>
<body>
<h1>로그인 정보 확인</h1>
<p>입력한 아이디: <%= request.getParameter("userid") %></p>
<p>입력한 비밀번호: <%= request.getParameter("password") %></p>
</body>
</html>

