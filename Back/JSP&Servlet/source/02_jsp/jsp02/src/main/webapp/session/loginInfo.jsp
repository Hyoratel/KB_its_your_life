<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = (String) session.getAttribute("userid");
    String pw = (String) session.getAttribute("password");
%>
<html>
<head><title>회원 정보</title></head>
<body>
<h2>세션에 저장된 사용자 정보</h2>
<p>아이디: <%= id %></p>
<p>비밀번호: <%= pw %></p>

<a href="logout.jsp">로그아웃</a>
</body>
</html>

