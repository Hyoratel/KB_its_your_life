<%--
  Created by IntelliJ IDEA.
  User: abide
  Date: 2025-05-29
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("userid");
    String pw = request.getParameter("password");

    // 세션에 저장
    session.setAttribute("userid", id);
    session.setAttribute("password", pw);
%>
<html>
<head><title>로그인 처리</title></head>
<body>
<h2>로그인 성공!</h2>
<a href="loginInfo.jsp">내 정보 보기</a>
</body>
</html>

