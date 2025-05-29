<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate(); // 세션 삭제
%>
<html>
<head><title>로그아웃</title></head>
<body>
<h2>로그아웃 되었습니다.</h2>
<a href="loginForm.html">다시 로그인</a>
</body>
</html>

